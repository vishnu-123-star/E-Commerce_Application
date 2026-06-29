package com.vishnu.shopsphere.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.vishnu.shopsphere.data.model.ProductData

class HomeRepository {

    private val firestore = FirebaseFirestore.getInstance()

    fun getProducts(
        onSuccess: (List<ProductData>) -> Unit,
        onFailure: (String) -> Unit
    ) {

        firestore.collection("products")
            .get()
            .addOnSuccessListener { result ->

                val products = result.documents.mapNotNull {

                    it.toObject(ProductData::class.java)

                }

                onSuccess(products)

            }
            .addOnFailureListener {

                onFailure(it.message ?: "Failed")

            }

    }
}