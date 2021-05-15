package com.s95ammar.roomdemo.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.s95ammar.roomdemo.R

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.insert_button).setOnClickListener {
            viewModel.insertProduct(
                findViewById<TextView>(R.id.name_edit_text).text.toString(),
                findViewById<TextView>(R.id.seller_edit_text).text.toString(),
                findViewById<TextView>(R.id.price_edit_text).text.toString().toIntOrNull(),
            )
        }

        viewModel.products.observe(this) { products ->
            Log.d("MainActivity", products.toString())
        }
    }


}
