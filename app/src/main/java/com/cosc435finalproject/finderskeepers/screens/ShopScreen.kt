package com.cosc435finalproject.finderskeepers.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.cosc435finalproject.finderskeepers.ProductListContent
import com.cosc435finalproject.finderskeepers.ProfileActivity
import com.cosc435finalproject.finderskeepers.productinfo.Product

@Composable
fun ShopScreen(navigateToProfile: (Product) -> Unit){
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text("See anything you like?",
                    fontSize = 25.sp)
            }, backgroundColor = Color.Transparent)
        },
        content = {it
            ProductListContent(navigateToProfile = navigateToProfile)
        }
    )
}