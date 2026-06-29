package com.vishnu.shopsphere.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.vishnu.shopsphere.data.model.ProductData

class ProductRepository {

    private val firestore = FirebaseFirestore.getInstance()

    fun uploadProduct(

        product: ProductData,

        onSuccess: () -> Unit,

        onFailure: (String) -> Unit

    ) {

        val document = firestore.collection("products").document()

        val newProduct = product.copy(
            id = document.id
        )

        document.set(newProduct)

            .addOnSuccessListener {

                onSuccess()

            }

            .addOnFailureListener {

                onFailure(it.message ?: "Upload Failed")

            }

    }
}