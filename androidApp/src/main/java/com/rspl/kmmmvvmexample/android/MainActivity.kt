package com.rspl.kmmmvvmexample.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rspl.kmmmvvmexample.Greeting
import android.widget.TextView
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)

    }
}
