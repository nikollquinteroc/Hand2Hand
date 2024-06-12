package com.nocountry.hand2hand.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.nocountry.hand2hand.ui.navigation.Navigation
import com.nocountry.hand2hand.ui.screens.ErrorScreen
import com.nocountry.hand2hand.ui.screens.InProgressScreen
import com.nocountry.hand2hand.ui.screens.create_product.CreateProductScreen
import com.nocountry.hand2hand.ui.theme.SaleAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SaleAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                }
            }
        }
    }
}



