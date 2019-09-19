package com.saurabh.demo.ui.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saurabh.demo.data.network.entities.Product
import com.saurabh.demo.data.network.repository.ProductRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class EditViewModel(private val repository: ProductRepository) : ViewModel() {

    fun saveProduct(
        product: Product,
        name: String,
        company: String,
        price: String
    ) {
        product.productName = name
        product.company = company
        product.price = price

        viewModelScope.launch {
            try {
                repository.saveProduct(product)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}