package com.chsh.orange

class AppUtils {
}

sealed class FetchStatus{
    object Fetching : FetchStatus()
    object Fetched : FetchStatus()
    object Init : FetchStatus()
}