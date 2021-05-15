package com.s95ammar.roomdemo.model.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.s95ammar.roomdemo.model.db.entity.ProductEntity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface ProductDao {

    @Insert
    fun insertProduct(product: ProductEntity): Single<Long>

    @Insert
    fun insertProducts(products: List<ProductEntity>): Single<Unit>

    @Delete
    fun deleteProduct(product: ProductEntity): Single<Unit>

    @Query("DELETE FROM products WHERE id = :id")
    fun deleteProductById(id: Int): Single<Unit>

    @Update
    fun updateProduct(product: ProductEntity): Single<Unit>

    @Update
    fun updateProducts(products: List<ProductEntity>): Single<Unit>

    @Query("SELECT * FROM products")
    fun getAllProducts(): Single<List<ProductEntity>>

    @Query("SELECT * FROM products")
    fun getAllProductsAsObservable(): Observable<List<ProductEntity>> // can use to automatically refresh

    @Query("SELECT * FROM products")
    fun getAllProductsAsLiveData(): LiveData<List<ProductEntity>> // can use to automatically refresh

}
