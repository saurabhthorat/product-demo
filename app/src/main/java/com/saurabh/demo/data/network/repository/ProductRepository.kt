package com.saurabh.demo.data.network.repository

import androidx.lifecycle.LiveData
import com.saurabh.demo.data.local.AppDb
import com.saurabh.demo.data.network.ApiService
import com.saurabh.demo.data.network.entities.Product

class ProductRepository(
    private val api: ApiService,
    private val db: AppDb
) {

    suspend fun fetchProductsFromNetwork(): List<Product> {
        return api.getProducts()
    }

    fun getProducts(): LiveData<List<Product>> {
        return db.productDao().getAll()
    }

    suspend fun saveProduct(product: Product) {
        return db.productDao().insert(product)
    }

    suspend fun saveAllProducts(products: List<Product>) {
        return db.productDao().insertAll(products)
    }

}