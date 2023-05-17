package com.cosc435finalproject.finderskeepers

import androidx.compose.runtime.Composable
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cosc435finalproject.finderskeepers.productinfo.Product
import com.cosc435finalproject.finderskeepers.screens.CartScreen
import com.cosc435finalproject.finderskeepers.screens.HomeScreen
import com.cosc435finalproject.finderskeepers.screens.ShopScreen

@Composable
fun BottomNavGraph(navController: NavHostController, navigateToProfile: (Product) -> Unit){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ){
        composable(route = BottomBarScreen.Home.route){
            HomeScreen(navigateToProfile = navigateToProfile)
        }
        composable(route = BottomBarScreen.Shop.route){
            ShopScreen(navigateToProfile = navigateToProfile)
        }
        composable(route = BottomBarScreen.Cart.route){
            CartScreen(navigateToProfile = navigateToProfile)
        }
    }
}