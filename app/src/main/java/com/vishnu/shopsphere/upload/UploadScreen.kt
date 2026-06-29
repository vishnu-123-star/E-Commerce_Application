package com.vishnu.shopsphere.upload

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.firebase.auth.FirebaseAuth
import com.vishnu.shopsphere.data.model.ProductData
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
@Composable
fun UploadScreen() {

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }

    var selectedImages by remember {
        mutableStateOf<List<Uri>>(emptyList())
    }

    val context = LocalContext.current
    val viewModel: UploadViewModel = viewModel()

    val imagePickerLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetMultipleContents()
        ) { uris ->
            selectedImages = uris
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Upload Product",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Product Title") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = price,
            onValueChange = { price = it },
            label = { Text("Price") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                imagePickerLauncher.launch("image/*")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Select Image")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text("Selected Images: ${selectedImages.size}")

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                if (title.isBlank() ||
                    description.isBlank() ||
                    price.isBlank()
                ) {

                    Toast.makeText(
                        context,
                        "Please fill all fields",
                        Toast.LENGTH_SHORT
                    ).show()

                    return@Button
                }

                if (selectedImages.isEmpty()) {

                    Toast.makeText(
                        context,
                        "Please select an image",
                        Toast.LENGTH_SHORT
                    ).show()

                    return@Button
                }

                viewModel.uploadImage(

                    context = context,

                    imageUri = selectedImages.first(),

                    onSuccess = { imageUrl ->

                        val email =
                            FirebaseAuth.getInstance()
                                .currentUser
                                ?.email ?: ""

                        val product = ProductData(

                            title = title,

                            description = description,

                            price = price,

                            imageUrl = imageUrl,

                            uploaderEmail = email

                        )

                        viewModel.uploadProduct(

                            product = product,

                            onSuccess = {

                                Toast.makeText(
                                    context,
                                    "Product Uploaded Successfully",
                                    Toast.LENGTH_LONG
                                ).show()

                                title = ""
                                description = ""
                                price = ""
                                selectedImages = emptyList()

                            },

                            onFailure = {

                                Toast.makeText(
                                    context,
                                    it,
                                    Toast.LENGTH_LONG
                                ).show()

                            }

                        )

                    },

                    onFailure = {

                        Toast.makeText(
                            context,
                            it,
                            Toast.LENGTH_LONG
                        ).show()

                    }

                )

            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Upload Product")

        }

    }
}