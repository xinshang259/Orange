package com.chsh.orange.sync.initializers

import androidx.work.Constraints
import androidx.work.NetworkType

val SyncConstraints
    get() = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.CONNECTED)
        .build()

class SyncWorkHelpers {


}