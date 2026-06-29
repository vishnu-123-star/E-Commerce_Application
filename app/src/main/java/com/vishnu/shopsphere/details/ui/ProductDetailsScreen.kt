package com.vishnu.shopsphere.details.ui

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.google.firebase.auth.FirebaseAuth
import com.vishnu.shopsphere.data.model.ProductData
import com.vishnu.shopsphere.favorites.FavoritesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailsScreen(
    product: ProductData
) {

    val viewModel: FavoritesViewModel = viewModel()
    val context = LocalContext.current

    Scaffold(

        topBar = {

            CenterAlignedTopAppBar(

                title = {

                    Text("🛍 Product Details")

                }

            )

        }

    ) { padding ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding)
                .padding(16.dp)

        ) {

            ElevatedCard {

                AsyncImage(

                    model = product.imageUrl,

                    contentDescription = product.title,

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp)

                )

            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(

                text = product.title,

                style = MaterialTheme.typography.headlineSmall,

                fontWeight = FontWeight.Bold

            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(

                text = "₹ ${product.price}",

                style = MaterialTheme.typography.headlineMedium,

                color = MaterialTheme.colorScheme.primary,

                fontWeight = FontWeight.Bold

            )

            Spacer(modifier = Modifier.height(24.dp))

            ElevatedCard(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "Description",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = product.description
                    )

                }

            }

            Spacer(modifier = Modifier.height(20.dp))

            ElevatedCard(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "Seller Information",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text("📧 ${product.uploaderEmail}")

                }

            }

            Spacer(modifier = Modifier.height(30.dp))

            Button(

                onClick = {

                    val email =
                        FirebaseAuth.getInstance()
                            .currentUser
                            ?.email ?: ""

                    viewModel.addToFavorites(

                        userEmail = email,

                        product = product,

                        onSuccess = {

                            Toast.makeText(
                                context,
                                "Added to Favorites ❤️",
                                Toast.LENGTH_SHORT
                            ).show()

                        },

                        onFailure = {

                            Toast.makeText(
                                context,
                                it,
                                Toast.LENGTH_SHORT
                            ).show()

                        }

                    )

                },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)

            ) {

                Text(
                    "❤️ Add to Favorites",
                    style = MaterialTheme.typography.titleMedium
                )

            }

            Spacer(modifier = Modifier.height(20.dp))

        }

    }

}