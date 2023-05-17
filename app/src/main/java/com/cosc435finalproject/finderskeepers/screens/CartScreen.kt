package com.cosc435finalproject.finderskeepers.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cosc435finalproject.finderskeepers.CartListContent
import com.cosc435finalproject.finderskeepers.NotificationFactory
import com.cosc435finalproject.finderskeepers.ProductListContent
import com.cosc435finalproject.finderskeepers.productinfo.InfoProvider
import com.cosc435finalproject.finderskeepers.productinfo.Product

@Composable
fun CartScreen(navigateToProfile: (Product) -> Unit){
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text("Have a nice day.",
                    fontSize = 25.sp)
            }, backgroundColor = Color.Transparent)
        },
        content = {it
            Column(modifier = Modifier.fillMaxSize()) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    CartListContent(navigateToProfile = navigateToProfile)
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                    horizontalArrangement = Arrangement.Center) {
                    CheckoutButton()
                }
            }
        }
    )
}

@Composable
private fun CheckoutButton(){
    val open = remember { mutableStateOf(false)  }
    val context = LocalContext.current
    val addtocartnotification = NotificationFactory(context, "Thank you!", "Your order has been received and is now processing.")

    Button(onClick = {
        open.value = true
        addtocartnotification.ShowNotification()
        InfoProvider.shoppingCart.clear()
        },
        enabled = InfoProvider.shoppingCart.isNotEmpty(),
        elevation =  ButtonDefaults.elevation(
        defaultElevation = 10.dp,
        pressedElevation = 15.dp,
        disabledElevation = 0.dp
    )) {
        Text(text = "Checkout")
    }

    if (open.value) {
        AlertDialog(
            onDismissRequest = {
                open.value = false
            },
            title = {
                Text("Thank you for your order!")
            },
            confirmButton = {},
            dismissButton = {
                Button(
                    onClick = {
                        open.value = false
                    }) {
                    Text("Ok")
                }
            }
        )
    }
}