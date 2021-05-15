package com.s95ammar.roomdemo.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.s95ammar.roomdemo.model.db.dao.ProductDao
import com.s95ammar.roomdemo.model.db.entity.ProductEntity

@Database(
    entities = [ProductEntity::class],
    version = 1
)
abstract class ProductsDatabase : RoomDatabase() {
    companion object {
        const val NAME = "products_db"
    }

    abstract val productsDao: ProductDao
}
