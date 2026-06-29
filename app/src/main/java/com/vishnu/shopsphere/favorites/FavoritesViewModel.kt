package com.vishnu.shopsphere.favorites

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.vishnu.shopsphere.data.model.ProductData
import com.vishnu.shopsphere.repository.FavoriteRepository

class FavoritesViewModel : ViewModel() {

    private val repository = FavoriteRepository()

    var favoriteProducts by mutableStateOf<List<ProductData>>(emptyList())
        private set

    fun loadFavorites(
        userEmail: String
    ) {

        repository.getFavorites(

            userEmail = userEmail,

            onSuccess = {

                favoriteProducts = it

            },

            onFailure = {

            }

        )

    }

    fun addToFavorites(

        userEmail: String,

        product: ProductData,

        onSuccess: () -> Unit,

        onFailure: (String) -> Unit

    ) {

        repository.addToFavorites(

            userEmail = userEmail,

            product = product,

            onSuccess = onSuccess,

            onFailure = onFailure

        )

    }

}