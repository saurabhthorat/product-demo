package com.saurabh.demo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saurabh.demo.data.network.entities.Product

@Database(
    entities = [Product::class],
    version = 1
)
abstract class AppDb : RoomDatabase() {

    abstract fun productDao(): ProductDao

}