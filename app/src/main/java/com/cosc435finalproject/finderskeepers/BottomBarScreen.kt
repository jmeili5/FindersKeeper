package com.cosc435finalproject.finderskeepers

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )
    object Shop : BottomBarScreen(
        route = "shop",
        title = "Shop",
        icon = Icons.Default.List
    )
    object Cart : BottomBarScreen(
        route = "cart",
        title = "Cart",
        icon = Icons.Default.ShoppingCart
    )
}
