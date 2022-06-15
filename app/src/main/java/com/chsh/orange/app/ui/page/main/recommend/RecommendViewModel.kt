package com.chsh.orange.app.ui.page.main.recommend

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chsh.orange.app.data.bean.Article
import com.chsh.orange.app.data.http.HttpService
import com.chsh.orange.app.ui.widgets.BannerData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecommendViewModel @Inject constructor(private var service: HttpService) : ViewModel() {

    var viewStates by mutableStateOf(RecommendViewState())
        private set

    init {
        dispatch(RecommendViewAction.FetchData)
    }

    private fun dispatch(action: RecommendViewAction) {
        when (action) {
            RecommendViewAction.FetchData -> fetchData()
            RecommendViewAction.Refresh -> refresh()
        }
    }

    private fun refresh() {
        fetchData()
    }

    private fun fetchData() {
        val imageListFlow = flow {
            delay(2000)
            emit(service.getBanners())
        }.map { bean ->
            val result = mutableListOf<BannerData>()
            bean.data?.forEach {
                result.add(BannerData(it.title ?: "", it.imagePath ?: "", it.url ?: ""))
            }
            result
        }
        val topListFlow = flow {
            emit(service.getTopArticles())
        }.map {
            it.data ?: emptyList()
        }

        viewModelScope.launch {
            imageListFlow.zip(topListFlow) { banners, tops ->
                viewStates = viewStates.copy(imageList = banners, topArticles = tops)
            }.onStart {
                viewStates = viewStates.copy(isRefreshing = true)
            }.catch {
                viewStates = viewStates.copy(isRefreshing = false)
            }.collect()
        }
    }

}


data class RecommendViewState(
//    val pagingData:
    val imageList: List<BannerData> = emptyList(),
    val topArticles: List<Article> = emptyList(),
    val isRefreshing: Boolean = false
)

sealed class RecommendViewAction {
    object FetchData : RecommendViewAction()
    object Refresh : RecommendViewAction()
}