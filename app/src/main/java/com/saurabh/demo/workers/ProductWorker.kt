package com.saurabh.demo.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.saurabh.demo.data.network.repository.ProductRepository
import kotlinx.coroutines.coroutineScope
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.lang.Exception

class ProductWorker(
    context: Context,
    workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters), KoinComponent {

    override suspend fun doWork() = coroutineScope {
        val repo: ProductRepository by inject()

        try {
            val products = repo.fetchProductsFromNetwork()
            repo.saveAllProducts(products)

            Result.success()
        } catch (e: Exception) {
            e.printStackTrace()

            Result.failure()
        }
    }

}