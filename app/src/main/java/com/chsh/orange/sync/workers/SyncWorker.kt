package com.chsh.orange.sync.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.OutOfQuotaPolicy
import androidx.work.WorkerParameters
import com.chsh.orange.coredata.Synchronizer
import com.chsh.orange.coredatastore.ChangeListVersions
import com.chsh.orange.sync.initializers.SyncConstraints
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.runningReduce
import kotlinx.coroutines.withContext

class SyncWorker constructor(
    private val appContext: Context,
    private val workerParams: WorkerParameters
) : CoroutineWorker(appContext, workerParams),
    Synchronizer {

    companion object {
        fun startupSyncWork() = OneTimeWorkRequestBuilder<DelegateWorker>()
            .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
            .setConstraints(SyncConstraints)
            .setInputData(SyncWorker::class.delegatedData())
            .build()
    }

    fun test() = callbackFlow<String> {
        send("2")
    }.map {

    }

    override suspend fun doWork(): Result = withContext(Dispatchers.IO){
        Result.success()
    }

    override suspend fun getChangeListVersions(): ChangeListVersions {
        return ChangeListVersions()
    }

    override suspend fun updateChangeListVersions(update: ChangeListVersions.() -> ChangeListVersions) {

    }

}