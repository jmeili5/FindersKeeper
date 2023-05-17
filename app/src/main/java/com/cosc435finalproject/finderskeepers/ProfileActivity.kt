package com.cosc435finalproject.finderskeepers

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.cosc435finalproject.finderskeepers.productinfo.Product
import com.cosc435finalproject.finderskeepers.ui.theme.FindersKeepersTheme

class ProfileActivity : ComponentActivity() {

    private val product: Product by lazy{
        intent?.getSerializableExtra(PRODUCT_ID) as Product
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            FindersKeepersTheme {
                ProfileScreen(product = product)
            }
        }
    }

    companion object{
        private const val PRODUCT_ID = "product_id"
        fun newIntent(context: Context, product: Product) =
            Intent(context, ProfileActivity::class.java).apply {
                putExtra(PRODUCT_ID, product)
            }
    }
}