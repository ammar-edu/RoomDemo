package com.s95ammar.roomdemo.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.s95ammar.roomdemo.model.db.entity.ProductEntity
import com.s95ammar.roomdemo.model.repository.MainRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel : ViewModel() {

    // better use dependency injection
    private val repository = MainRepository()

    val products = repository.getAllProductsAsLiveData()

    fun insertProduct(name: String, seller: String, price: Int?) {
        val product = ProductEntity(name, seller, price ?: 0)

        // TODO LESSON 6: handle disposable
        repository.insertProduct(product)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ id ->
                Log.d("MainViewModel", "success. id = $id")
            },{ exception ->
                Log.d("MainViewModel", "error: ${exception.message}")
            })
    }
}