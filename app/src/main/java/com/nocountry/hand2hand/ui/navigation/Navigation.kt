package com.nocountry.hand2hand.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nocountry.hand2hand.ui.screens.InProgressScreen
import com.nocountry.hand2hand.ui.screens.OnBoardingScreen
import com.nocountry.hand2hand.ui.screens.create_product.CreateProductScreen
import com.nocountry.hand2hand.ui.screens.home.HomeScreen
import com.nocountry.hand2hand.ui.screens.account.InformacionPersonalScreen
import com.nocountry.hand2hand.ui.screens.login.LoginScreen
import com.nocountry.hand2hand.ui.screens.account.MiCuentaScreen
import com.nocountry.hand2hand.ui.screens.account.ProfileScreen
import com.nocountry.hand2hand.ui.screens.register.RegisterScreen


@Composable
fun Navigation(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = MainDestinations.ONBOARDING_ROUTE
    ) {
        composable(MainDestinations.ONBOARDING_ROUTE) {
            OnBoardingScreen(navigateToLogin = { navController.navigate(MainDestinations.LOGIN_ROUTE) })
        }
        composable(MainDestinations.LOGIN_ROUTE) {
            LoginScreen(navigation = navController)
        }
        composable(MainDestinations.REGISTER_ROUTE){
            RegisterScreen(navigation = navController)
        }
        composable(MainDestinations.HOME_ROUTE) {
            HomeScreen(navController)
        }
        composable(MainDestinations.AUCTION_ROUTE) {
            InProgressScreen(navigateUp = { navController.navigateUp() })
        }
        composable(MainDestinations.SELLING_ROUTE) {
            CreateProductScreen(
                navigateUp = { navController.navigateUp() },
                navigateHome = { navController.navigate(MainDestinations.HOME_ROUTE) }
            )
        }
        composable(MainDestinations.MESSAGE_ROUTE) {
            InProgressScreen(navigateUp = { navController.navigateUp() })
        }
        composable(MainDestinations.ACCOUNT_ROUTE) {
            ProfileScreen(navigation = navController)
        }
        composable("MiCuenta"){
            MiCuentaScreen(navigation = navController)
        }
        composable("InformacionPersonal"){
            InformacionPersonalScreen(navigation = navController)
        }
    }
}