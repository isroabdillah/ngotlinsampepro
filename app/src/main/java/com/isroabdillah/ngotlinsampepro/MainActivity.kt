package com.isroabdillah.ngotlinsampepro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var text1 : TextView
    private lateinit var btn1 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text1 = findViewById(R.id.text1)
        btn1 = findViewById(R.id.btn1)

//        manipulasi text
        text1.text ="Hello mas bro"


//        2 INTENT
//        - EXPLICIT INTENT
        btn1.setOnClickListener{
//            open MAINACTVTY
            val intentDestination = Intent(this@MainActivity, Main2Activity::class.java)
            intentDestination.putExtra(Main2Activity.EXTRA_DATA, "Santai dulu mas broo")
            startActivity(intentDestination)
        }
    }
}