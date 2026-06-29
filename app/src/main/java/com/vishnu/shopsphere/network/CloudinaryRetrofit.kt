package com.vishnu.shopsphere.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CloudinaryRetrofit {

    private const val BASE_URL = "https://api.cloudinary.com/v1_1/diuekzere/"

    val api: CloudinaryApi by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
            .create(CloudinaryApi::class.java)

    }
}