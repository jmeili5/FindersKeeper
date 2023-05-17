package com.cosc435finalproject.finderskeepers.productinfo

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cosc435finalproject.finderskeepers.R
import java.io.Serializable

@Entity(tableName = "product")
data class Product(
    @PrimaryKey val id: Int,
    val name: String,
    val type: String,
    val price: Double,
    val description: String,
    val imageId: Int,
    val promotion: Int,
) :Serializable