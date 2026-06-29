package com.vishnu.shopsphere.home.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.vishnu.shopsphere.data.model.ProductData
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterial3Api::class) // Fixes the Experimental API Warning
@Composable
fun HomeScreen(
    onProductClick: (ProductData) -> Unit,
    onUploadClick: () -> Unit,
    onFavoritesClick: () -> Unit
) {
    val viewModel: HomeViewModel = viewModel()
    val recommendedViewModel: RecommendedViewModel = viewModel()

    LaunchedEffect(Unit) {
        viewModel.loadProducts()
    }

    var search by remember { mutableStateOf("") }

    val filteredProducts = viewModel.products.filter {

        it.title.contains(search, ignoreCase = true) ||
                it.description.contains(search, ignoreCase = true)

    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("🛒 ShopSphere") }
            )
        },
        floatingActionButton = {
            Column {
                FloatingActionButton(onClick = onFavoritesClick) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorites"
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                FloatingActionButton(onClick = onUploadClick) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Upload Product"
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding) // Handles Scaffolds top/bottom bar paddings
        ) {
            OutlinedTextField(
                value = search,
                onValueChange = { search = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                placeholder = { Text("🔍 Search Products") },
                singleLine = true
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize() // Removed redundant .padding(padding) here
            ) {
                items(filteredProducts) { product ->
                    ProductItem(
                        product = product,
                        onClick = { onProductClick(product) }
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "⭐ Recommended Products",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(16.dp)
                    )
                }

                items(recommendedViewModel.products) { product ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            // Note: Ensure your ProductData has both .image and .imageUrl matching your model fields
                            AsyncImage(
                                model = product.image,
                                contentDescription = product.title,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(180.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = product.title,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = "₹ ${product.price}")
                        }
                    }
                }
            }
        } // Closes parent Column
    } // Closes Scaffold content
} // Closes HomeScreen Composable

@Composable
fun ProductItem(
    product: ProductData,
    onClick: () -> Unit
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = product.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = product.title,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = product.description,
                    maxLines = 2,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "₹ ${product.price}",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}