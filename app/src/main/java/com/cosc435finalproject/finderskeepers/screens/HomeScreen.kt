package com.cosc435finalproject.finderskeepers.screens

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cosc435finalproject.finderskeepers.ProductListContent
import com.cosc435finalproject.finderskeepers.PromoListContent
import com.cosc435finalproject.finderskeepers.PromoListItem
import com.cosc435finalproject.finderskeepers.R
import com.cosc435finalproject.finderskeepers.productinfo.Product

@Composable
fun HomeScreen(navigateToProfile: (Product) -> Unit){
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Greetings!",
                fontSize = 25.sp)
            }, backgroundColor = Color.Transparent)
        },
        content = { it
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                ) {
                    Column {
                        /*Text(text = "Featured",
                            fontSize = 30.sp,
                            modifier = Modifier.padding(horizontal = 30.dp)
                        )*/
                        PromoListContent(navigateToProfile = navigateToProfile)
                        ShareOnIGButton()
                    }
                }
            }
        }
    )
}

@Composable
fun ShareOnIGButton(){
    val context = LocalContext.current
    val sendtoinstagram = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/")) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.padding(40.dp)
    ) {
        IconButton(onClick = {
            context.startActivity(sendtoinstagram)
        }) {
            Image(
                painter = painterResource(id = R.drawable.iglogo),
                modifier = Modifier.size(40.dp),
                contentDescription = "Logo")
        }
        Text(text ="Feeling yourself? Tag us on Instagram")
    }
}