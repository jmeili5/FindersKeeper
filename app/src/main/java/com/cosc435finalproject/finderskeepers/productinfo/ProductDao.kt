package com.cosc435finalproject.finderskeepers.productinfo

import androidx.room.*


@Dao
interface ProductDao {
    @Query("SELECT * FROM product")
    suspend fun getAllProducts(): List<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: Product)

    @Query("SELECT * FROM product WHERE id = :productId")
    suspend fun getProductById(productId: Int): Product?
}

@Database(entities = [Product::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}