package com.saurabh.demo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.saurabh.demo.data.network.entities.Product
import com.saurabh.demo.data.network.repository.ProductRepository

class HomeViewModel(repository: ProductRepository) : ViewModel() {

    var products: LiveData<List<Product>> = repository.getProducts()

}