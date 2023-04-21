package com.isroabdillah.ngotlinsampepro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Main2Activity : AppCompatActivity() {
    companion object{
        const val EXTRA_DATA = "extra_data"
    }
    private lateinit var text1: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        text1 = findViewById(R.id.text1)
        val strData = intent.getStringExtra(EXTRA_DATA)
        text1.text = strData
    }
}