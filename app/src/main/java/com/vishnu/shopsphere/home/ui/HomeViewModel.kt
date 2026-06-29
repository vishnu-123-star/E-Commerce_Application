package com.vishnu.shopsphere.home.ui

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.vishnu.shopsphere.data.model.ProductData
import com.vishnu.shopsphere.repository.HomeRepository

class HomeViewModel : ViewModel() {

    private val repository = HomeRepository()

    var products by mutableStateOf<List<ProductData>>(emptyList())
        private set

    fun loadProducts() {

        repository.getProducts(

            onSuccess = {

                products = it

            },

            onFailure = {

            }

        )

    }

}