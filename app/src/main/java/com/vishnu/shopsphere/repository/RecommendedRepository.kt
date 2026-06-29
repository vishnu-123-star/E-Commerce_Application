package com.vishnu.shopsphere.repository

import com.vishnu.shopsphere.data.model.RecommendedProduct
import com.vishnu.shopsphere.network.FakeStoreRetrofit

class RecommendedRepository {

    suspend fun getRecommendedProducts(): List<RecommendedProduct> {

        val response =
            FakeStoreRetrofit.api.getProducts()

        return if (response.isSuccessful) {

            response.body() ?: emptyList()

        } else {

            emptyList()

        }

    }

}