package com.chsh.orange.app.util

class AppUtils {
}

sealed class FetchStatus{
    object Fetching : FetchStatus()
    object Fetched : FetchStatus()
    object Init : FetchStatus()
}