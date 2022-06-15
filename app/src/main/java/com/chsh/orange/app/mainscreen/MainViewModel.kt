package com.chsh.orange.app.mainscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chsh.orange.app.util.FetchStatus
import com.chsh.orange.app.ext.setState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val viewStates : MutableLiveData<MainViewState> = MutableLiveData(MainViewState())
    private val viewEvent : Channel<MainViewEvent> = Channel<MainViewEvent>()
    val eventFlow = viewEvent.receiveAsFlow()


    private fun fetchNews(){
        viewStates.setState {
            copy(fetchState = FetchStatus.Fetching)
        }
        viewModelScope.launch {
            delay(5000)
            viewStates.setState {
                copy(fetchState = FetchStatus.Fetched)
            }
            viewEvent.send(MainViewEvent.ShowToast("加载成功"))
        }
    }



}