package com.vishnu.shopsphere.home.ui

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vishnu.shopsphere.data.model.RecommendedProduct
import com.vishnu.shopsphere.repository.RecommendedRepository
import kotlinx.coroutines.launch

class RecommendedViewModel : ViewModel() {

    private val repository = RecommendedRepository()

    var products by mutableStateOf<List<RecommendedProduct>>(emptyList())
        private set

    init {

        loadProducts()

    }

    private fun loadProducts() {

        viewModelScope.launch {

            products =
                repository.getRecommendedProducts()

        }

    }

}