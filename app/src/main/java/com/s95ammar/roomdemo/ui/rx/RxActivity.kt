package com.s95ammar.roomdemo.ui.rx

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.s95ammar.roomdemo.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*
        findViewById<Button>(R.id.start_button).setOnClickListener {
            doWork()
        }
*/
    }


    fun doWork() {

/*
        Thread {
            Log.d("MainActivity", "before work")
            Log.d("MainActivity", Thread.currentThread().name)
            Thread.sleep(4000)
            throw Exception("failed to connect")

            Log.d("MainActivity", "after work")

        }.start()
*/


        val single = getSingle()


        single
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

//                findViewById<TextView>(R.id.text_view).text = "result"

            }, { exception ->

                Toast.makeText(this, exception.message, Toast.LENGTH_SHORT).show()

            })
    }

    private fun getSingle() = Single.fromCallable {
        Log.d("MainActivity", "before work")
        Log.d("MainActivity", Thread.currentThread().name)
        Thread.sleep(4000)
        Log.d("MainActivity", "after work")

        return@fromCallable "This is the result"
    }
}
