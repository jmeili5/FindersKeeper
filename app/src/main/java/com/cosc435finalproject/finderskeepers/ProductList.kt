package com.cosc435finalproject.finderskeepers

import android.security.identity.AccessControlProfile
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.cosc435finalproject.finderskeepers.productinfo.InfoProvider
import com.cosc435finalproject.finderskeepers.productinfo.Product
import kotlinx.coroutines.runBlocking
import java.security.AccessController.getContext

@Composable
fun ProductListContent(navigateToProfile: (Product) -> Unit){
    //val products = remember { InfoProvider.productList }
    val products =  runBlocking { InfoProvider.getPromoList()}

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ){
        items(
            items = products,
            itemContent = {
                ProductListItem(product = it, navigateToProfile)
            }
        )
    }
}