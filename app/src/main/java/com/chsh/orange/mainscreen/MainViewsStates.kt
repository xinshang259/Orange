package com.chsh.orange.mainscreen

import com.chsh.orange.FetchStatus
import com.chsh.orange.data.NewsItem

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