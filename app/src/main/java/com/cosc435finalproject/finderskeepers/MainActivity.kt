package com.cosc435finalproject.finderskeepers

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.ContactsContract.Profile
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cosc435finalproject.finderskeepers.ProductListContent
import com.cosc435finalproject.finderskeepers.ProfileActivity
import com.cosc435finalproject.finderskeepers.databinding.ActivityMainBinding
import com.cosc435finalproject.finderskeepers.productinfo.InfoProvider
import com.cosc435finalproject.finderskeepers.productinfo.Product
import com.cosc435finalproject.finderskeepers.ui.theme.FindersKeepersTheme
import kotlinx.coroutines.FlowPreview

class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        InfoProvider.initialize(applicationContext)
        setContent {
            FindersKeepersTheme {
                MainScreen{
                    startActivity(ProfileActivity.newIntent(this, it))
                }
            }
        }
    }
}