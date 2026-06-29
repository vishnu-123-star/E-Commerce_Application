package com.vishnu.shopsphere

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.vishnu.shopsphere.navigation.AppNavigation
import com.vishnu.shopsphere.ui.theme.ShopSphereTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ShopSphereTheme {
                AppNavigation()
            }
        }
    }
}