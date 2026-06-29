package com.vishnu.shopsphere.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vishnu.shopsphere.auth.LoginScreen
import com.vishnu.shopsphere.auth.RegisterScreen
import com.vishnu.shopsphere.details.ui.ProductDetailsScreen
import com.vishnu.shopsphere.favorites.FavoritesScreen
import com.vishnu.shopsphere.home.ui.HomeScreen
import com.vishnu.shopsphere.upload.UploadScreen
import com.vishnu.shopsphere.utils.SelectedProduct

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        // Login
        composable("login") {

            LoginScreen(

                onLoginSuccess = {

                    navController.navigate("home") {
                        popUpTo("login") {
                            inclusive = true
                        }
                    }

                },

                onRegisterClick = {

                    navController.navigate("register")

                }

            )

        }

        // Register
        composable("register") {

            RegisterScreen(

                onRegisterSuccess = {

                    navController.popBackStack()

                },

                onBackToLogin = {

                    navController.popBackStack()

                }

            )

        }

        // Home
        composable("home") {

            HomeScreen(

                onProductClick = { product ->

                    SelectedProduct.product = product

                    navController.navigate("details")

                },

                onUploadClick = {

                    navController.navigate("upload")

                },

                onFavoritesClick = {

                    navController.navigate("favorites")

                }

            )

        }

        // Upload
        composable("upload") {

            UploadScreen()

        }

        // Favorites
        composable("favorites") {

            FavoritesScreen(

                onProductClick = { product ->

                    SelectedProduct.product = product

                    navController.navigate("details")

                }

            )

        }

        // Product Details
        composable("details") {

            SelectedProduct.product?.let {

                ProductDetailsScreen(
                    product = it
                )

            }

        }

    }

}