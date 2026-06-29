package com.vishnu.shopsphere.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.vishnu.shopsphere.data.model.ProductData

class FavoriteRepository {

    private val firestore = FirebaseFirestore.getInstance()

    fun addToFavorites(
        userEmail: String,
        product: ProductData,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {

        firestore.collection("favorites")
            .document(userEmail)
            .collection("products")
            .document(product.id)
            .set(product)
            .addOnSuccessListener {

                onSuccess()

            }
            .addOnFailureListener {

                onFailure(it.message ?: "Failed")

            }

    }

    fun getFavorites(
        userEmail: String,
        onSuccess: (List<ProductData>) -> Unit,
        onFailure: (String) -> Unit
    ) {

        firestore.collection("favorites")
            .document(userEmail)
            .collection("products")
            .get()
            .addOnSuccessListener { result ->

                val list =
                    result.toObjects(ProductData::class.java)

                onSuccess(list)

            }
            .addOnFailureListener {

                onFailure(it.message ?: "Failed")

            }

    }

}