package com.chsh.orange.sync.workers

import android.content.Context
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent
import kotlin.reflect.KClass

private const val WORKER_CLASS_NAME = "RouterWorkerDelegateClassName"
private const val TAG = "DelegateWorker"

@EntryPoint
@InstallIn(SingletonComponent::class)
interface HiltWorkerFactoryEntryPoint {
    fun hiltWorkerFactory(): HiltWorkerFactory
}

internal fun KClass<out CoroutineWorker>.delegatedData() =
    Data.Builder()
        .putString(WORKER_CLASS_NAME, qualifiedName)
        .build()

class DelegateWorker(private val appContext: Context, private val workerParameters: WorkerParameters) :
    CoroutineWorker(appContext, workerParameters) {

    private val workerClassName = workerParameters.inputData.getString(WORKER_CLASS_NAME) ?: ""

    private val delegateWorker =
        EntryPointAccessors.fromApplication<HiltWorkerFactoryEntryPoint>(appContext)
            .hiltWorkerFactory()
            .createWorker(appContext, workerClassName, workerParameters)
                as? CoroutineWorker
            ?: throw IllegalArgumentException("Unable to find appropriate worker")

    override suspend fun getForegroundInfo(): ForegroundInfo =
        delegateWorker.getForegroundInfo()

    override suspend fun doWork(): Result =
        delegateWorker.doWork()
}