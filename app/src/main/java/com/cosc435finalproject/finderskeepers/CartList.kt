package com.cosc435finalproject.finderskeepers

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.cosc435finalproject.finderskeepers.productinfo.InfoProvider
import com.cosc435finalproject.finderskeepers.productinfo.Product
import kotlinx.coroutines.runBlocking

@Composable
fun CartListContent(navigateToProfile: (Product) -> Unit){
    val cartitems =  remember { InfoProvider.shoppingCart }

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ){
        items(
            items = cartitems ,
            itemContent = {
                ProductListItem(product = it, navigateToProfile)
            }
        )
    }
}

@Composable
fun CartListItem(product: Product, navigateToProfile: (Product) -> Unit){
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 5.dp,
        //backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row(
            Modifier.clickable { navigateToProfile(product) }
        ) {
            ProductImage(product = product)
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ){
                Text(text = product.name, style = MaterialTheme.typography.h6)
                Text(text = "View Product", style = MaterialTheme.typography.caption)
            }
        }
    }
}

@Composable
private fun ProductImage(product: Product){
    Image(
        painter = painterResource(id = product.imageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}

@Composable
private fun Checkout(){

}