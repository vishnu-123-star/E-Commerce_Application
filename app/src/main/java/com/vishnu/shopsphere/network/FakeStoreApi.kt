

package com.vishnu.shopsphere.network

import com.vishnu.shopsphere.data.model.RecommendedProduct
import retrofit2.Response
import retrofit2.http.GET

interface FakeStoreApi {

    @GET("products")
    suspend fun getProducts(): Response<List<RecommendedProduct>>

}