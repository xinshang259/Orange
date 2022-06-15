package com.chsh.orange.app.mainscreen

import com.chsh.orange.app.util.FetchStatus
import com.chsh.orange.app.data.NewsItem

data class MainViewState(
    val fetchState: FetchStatus = FetchStatus.Init,
    val newsList: List<NewsItem> = emptyList()
)

sealed class MainViewEvent {
    data class ShowToast(val message: String) : MainViewEvent()
}

sealed class MainViewAction {
    data class NewItemClicked(val newsItem: NewsItem) : MainViewAction()
    object FetchNews : MainViewAction()
}