package com.vishnu.shopsphere.favorites

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.google.firebase.auth.FirebaseAuth
import com.vishnu.shopsphere.data.model.ProductData

@Composable
fun FavoritesScreen(

    onProductClick: (ProductData) -> Unit

) {

    val viewModel: FavoritesViewModel = viewModel()

    val email =
        FirebaseAuth.getInstance().currentUser?.email ?: ""

    LaunchedEffect(Unit) {

        viewModel.loadFavorites(email)

    }

    LazyColumn {

        items(viewModel.favoriteProducts) { product ->

            Card(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .clickable {

                        onProductClick(product)

                    }

            ) {

                Column(
                    modifier = Modifier.padding(12.dp)
                ) {

                    AsyncImage(

                        model = product.imageUrl,

                        contentDescription = null,

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)

                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(product.title)

                    Text("₹ ${product.price}")

                }

            }

        }

    }

}