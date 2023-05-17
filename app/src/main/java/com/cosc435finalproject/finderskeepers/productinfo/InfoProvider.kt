package com.cosc435finalproject.finderskeepers.productinfo

import android.content.Context
import androidx.room.Room
import com.cosc435finalproject.finderskeepers.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object InfoProvider {

    private lateinit var productDao: ProductDao
    var shoppingCart = mutableListOf<Product>()

    fun initialize(context: Context) {
        val db = Room.databaseBuilder(
            context.applicationContext,
            ProductDatabase::class.java,
            "product_database"
        ).build()

        productDao = db.productDao()

        GlobalScope.launch {
            if (productDao.getAllProducts().isEmpty()) {
                productDao.insertProduct(
                    Product(
                        1,
                        "Yellow Graphic T-Shirt",
                        "Tops",
                        40.00,
                        "A yellow cotton t-shirt with bold graphics on the front.",
                        R.drawable.yellowt,
                        1,
                    )
                )
                productDao.insertProduct(
                    Product(
                        2,
                        "Gray Plain Pants",
                        "Bottoms",
                        40.00,
                        "A pair of essential gray pants.",
                        R.drawable.grayp,
                        1,
                    )
                )
                productDao.insertProduct(
                    Product(
                        3,
                        "Leather Handbag",
                        "Accessories",
                        40.00,
                        "A brown leather handbag made of plush leather.",
                        R.drawable.handbagb,
                        1,
                    ),
                )
                productDao.insertProduct(
                    Product(
                        4,
                        "Red Graphic T-shirt",
                        "Tops",
                        40.00,
                        "A red cotton t-shirt with bold graphics on the front.",
                        R.drawable.redt,
                        1,
                    )
                )
                productDao.insertProduct(
                    Product(
                        5,
                        "Denim Skirt",
                        "Bottoms",
                        40.00,
                        "A denim skirt.",
                        R.drawable.denims,
                        1,
                    )
                )
                productDao.insertProduct(
                    Product(
                        6,
                        "Leather Handbag",
                        "Accessories",
                        40.00,
                        "A red leather handbag made of plush leather.",
                        R.drawable.handbagr,
                        1,
                    )
                )
                productDao.insertProduct(
                    Product(
                        7,
                        "Black Graphic T-shirt",
                        "Tops",
                        40.00,
                        "A black cotton t-shirt with bold graphics on the front.",
                        R.drawable.blackt,
                        1,
                    )
                )
                productDao.insertProduct(
                    Product(
                        5,
                        "Linen Skirt",
                        "Bottoms",
                        40.00,
                        "A white linen skirt.",
                        R.drawable.whites,
                        1,
                    )
                )
            }
        }
    }
    suspend fun getPromoId(productId: Int): Product? {
        return productDao.getProductById(productId)
    }
    suspend fun getPromoList(): List<Product> = withContext(Dispatchers.IO) {
        productDao.getAllProducts()
    }
}
