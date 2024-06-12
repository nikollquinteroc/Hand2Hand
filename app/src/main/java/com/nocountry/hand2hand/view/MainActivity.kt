package com.nocountry.hand2hand.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.google.firebase.FirebaseApp
import com.google.firebase.appcheck.FirebaseAppCheck
//import com.google.firebase.appcheck.debug.DebugAppCheckProviderFactory
import com.google.firebase.appcheck.ktx.appCheck
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import com.nocountry.hand2hand.model.SubCategory
import com.nocountry.hand2hand.prueba.PruebaScreen
import com.nocountry.hand2hand.view.navigation.Navigation
import com.nocountry.hand2hand.view.screens.CategoriaScreen
import com.nocountry.hand2hand.view.screens.RegisterScreen
import com.nocountry.hand2hand.view.screens.SubcategoriaScreen
import com.nocountry.hand2hand.view.theme.SaleAppTheme

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
                    //SubcategoriaScreen(rememberNavController())
                   Navigation(this)
                }
            }
        }
    }
}