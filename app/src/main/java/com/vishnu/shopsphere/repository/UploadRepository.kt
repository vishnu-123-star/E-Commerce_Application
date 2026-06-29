package com.vishnu.shopsphere.repository

import android.content.Context
import android.net.Uri
import com.vishnu.shopsphere.network.CloudinaryResponse
import com.vishnu.shopsphere.network.CloudinaryRetrofit
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class UploadRepository {

    fun uploadImage(
        context: Context,
        imageUri: Uri,
        onSuccess: (String) -> Unit,
        onFailure: (String) -> Unit
    ) {

        val inputStream = context.contentResolver.openInputStream(imageUri)

        val file = File.createTempFile("upload", ".jpg", context.cacheDir)

        inputStream?.use { input ->
            file.outputStream().use { output ->
                input.copyTo(output)
            }
        }

        val requestFile =
            file.asRequestBody("image/*".toMediaTypeOrNull())

        val body =
            MultipartBody.Part.createFormData(
                "file",
                file.name,
                requestFile
            )

        val preset =
            "shopsphere".toRequestBody("text/plain".toMediaTypeOrNull())

        CloudinaryRetrofit.api.uploadImage(
            body,
            preset
        ).enqueue(object : Callback<CloudinaryResponse> {

            override fun onResponse(
                call: Call<CloudinaryResponse>,
                response: Response<CloudinaryResponse>
            ) {

                if (response.isSuccessful && response.body() != null) {

                    onSuccess(response.body()!!.secure_url)

                } else {

                    onFailure("Upload Failed")

                }

            }

            override fun onFailure(
                call: Call<CloudinaryResponse>,
                t: Throwable
            ) {

                onFailure(t.message ?: "Unknown Error")

            }

        })

    }

}