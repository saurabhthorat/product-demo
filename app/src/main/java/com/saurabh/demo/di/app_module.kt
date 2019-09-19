package com.saurabh.demo.di

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.saurabh.demo.data.local.AppDb
import com.saurabh.demo.data.network.ApiService
import com.saurabh.demo.data.network.repository.ProductRepository
import com.saurabh.demo.ui.edit.EditViewModel
import com.saurabh.demo.ui.home.HomeViewModel
import com.saurabh.demo.workers.ProductWorker
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val app_module = module {
    single { ApiService.create() }

    single {
        Room.databaseBuilder(androidApplication(), AppDb::class.java, "app.db")
            .fallbackToDestructiveMigration()
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    val request = OneTimeWorkRequestBuilder<ProductWorker>().build()
                    WorkManager.getInstance(androidContext()).enqueue(request)
                }
            })
            .build()
    }

    single { ProductRepository(get(), get()) }

    viewModel { HomeViewModel(get()) }
    viewModel { EditViewModel(get()) }
}