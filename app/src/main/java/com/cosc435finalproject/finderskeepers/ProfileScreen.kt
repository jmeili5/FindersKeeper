package com.cosc435finalproject.finderskeepers

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.cosc435finalproject.finderskeepers.productinfo.InfoProvider
import com.cosc435finalproject.finderskeepers.productinfo.Product

@Composable
fun ProfileScreen(product: Product){
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()){
        BoxWithConstraints {
            Surface{
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ) {
                    ProfileHeader(product = product, containerHeight = this@BoxWithConstraints.maxHeight)
                    ProfileContent(product = product, containerHeight = this@BoxWithConstraints.maxHeight)
                }
            }
        }
    }
}

@Composable
private fun ProfileHeader(
    product: Product,
    containerHeight: Dp
){
    Image(
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth(),
        painter = painterResource(id = product.imageId),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

@Composable
private fun ProfileContent(
    product: Product,
    containerHeight: Dp
){
    val open = remember { mutableStateOf(false)  }
    Column {
        ProductName(product = product)
        ProfileProperty(value = product.description)
        AddToCartButton(product = product)
        //Spacer(modifier = Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
    }
}

@Composable
private fun ProductName(product: Product){
    Column(modifier = Modifier.padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = product.name,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$" + (product.price).toString(),
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun ProfileProperty(value: String){
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider(modifier = Modifier.padding(bottom = 4.dp))
        Text(
            text = value,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Visible
        )
    }
}

@Composable
private fun AddToCartButton(product: Product){
    val open = remember { mutableStateOf(false)  }

    Row(modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.Center) {
        Button(onClick = {
            open.value = true
        },elevation =  ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        )) {
            Text(text = "Add to Cart")
        }
    }

    if (open.value) {
        AlertDialog(
            onDismissRequest = {
                open.value = false
            },
            title = {
                Text(text = "Add " + product.name + " to cart?")
            },
            confirmButton = {
                Button(
                    onClick = {
                        InfoProvider.shoppingCart.add(product)
                        open.value = false
                    }) {
                    Text("Yes")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        open.value = false
                    }) {
                    Text("Cancel")
                }
            }
        )
    }
}

/*@Composable
private fun ConfirmDialog (product: Product){
    Column {
        val open = remember { mutableStateOf(false)  }

        Button(onClick = {
            open.value = true
        }) {
            Text("Click me")
        }

        if (open.value) {

            AlertDialog(
                onDismissRequest = {
                    open.value = false
                },
                title = {
                    Text(text = "Dialog Title")
                },
                text = {
                    Text("Here is a text ")
                },
                confirmButton = {
                    Button(

                        onClick = {
                            open.value = false
                        }) {
                        Text("This is the Confirm Button")
                    }
                },
                dismissButton = {
                    Button(

                        onClick = {
                            open.value = false
                        }) {
                        Text("This is the dismiss Button")
                    }
                }
            )
        }
    }
}*/