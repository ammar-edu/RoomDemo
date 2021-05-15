package com.s95ammar.roomdemo.model.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    val name: String,
    val seller: String,
    val price: Int
) {

    @PrimaryKey(autoGenerate = true)
    var id = 0
}
