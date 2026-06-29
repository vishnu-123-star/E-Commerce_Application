package com.vishnu.shopsphere.upload

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import com.vishnu.shopsphere.repository.UploadRepository
import com.vishnu.shopsphere.data.model.ProductData
import com.vishnu.shopsphere.repository.ProductRepository

class UploadViewModel : ViewModel() {

    private val repository = UploadRepository()

    fun uploadImage(
        context: Context,
        imageUri: Uri,
        onSuccess: (String) -> Unit,
        onFailure: (String) -> Unit
    ) {

        repository.uploadImage(
            context,
            imageUri,
            onSuccess,
            onFailure
        )

    }
    private val productRepository = ProductRepository()

    fun uploadProduct(

        product: ProductData,

        onSuccess: () -> Unit,

        onFailure: (String) -> Unit

    ) {

        productRepository.uploadProduct(

            product,

            onSuccess,

            onFailure

        )

    }
}