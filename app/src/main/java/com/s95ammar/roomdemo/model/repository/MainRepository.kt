package com.s95ammar.roomdemo.model.repository

import androidx.lifecycle.LiveData
import androidx.room.Room
import com.s95ammar.roomdemo.RoomDemoApplication
import com.s95ammar.roomdemo.model.db.ProductsDatabase
import com.s95ammar.roomdemo.model.db.entity.ProductEntity
import io.reactivex.rxjava3.core.Single

class MainRepository {

    // better use dependency injection
    private val db: ProductsDatabase = createDatabase()

    fun insertProduct(product: ProductEntity): Single<Long> {
        return db.productsDao.insertProduct(product)
    }

    fun getAllProductsAsLiveData(): LiveData<List<ProductEntity>> {
        return db.productsDao.getAllProductsAsLiveData()
    }

    private fun createDatabase(): ProductsDatabase {
        return Room.databaseBuilder(
            RoomDemoApplication.instance!!,
            ProductsDatabase::class.java,
            ProductsDatabase.NAME
        ).build()
    }

}
