package com.isroabdillah.ngotlinsampepro

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var text1 : TextView
    private lateinit var btn1 : Button
    private lateinit var btnPhone : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text1 = findViewById(R.id.text1)
        btn1 = findViewById(R.id.btn1)
        btnPhone = findViewById(R.id.btn_phone)

//        manipulasi text
        text1.text ="Hello mas bro"


//        2 INTENT
//        - EXPLICIT INTENT
        btn1.setOnClickListener{
//            open MAINACTVTY
            val intentDestination = Intent(this@MainActivity, Main2Activity::class.java)
//            intentDestination.putExtra(Main2Activity.EXTRA_DATA, "Santai dulu mas broo")

//            KIRIM DATA DENGAN DATA CLASS
            intentDestination.putExtra(Main2Activity.EXTRA_DATA, Student("ISRO", "111111"))
//            startActivity(intentDestination)

            resultLauncher.launch(intentDestination)
        }

//        - IMPLICIT INTENT

        btnPhone.setOnClickListener{
            val number = "1000100"
            val intentPhone = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
            startActivity(intentPhone)
        }
    }

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result -> if (result.resultCode==Main2Activity.RESULT_CODE && result.data!=null){
            val name = result.data?.getStringExtra(Main2Activity.EXTRA_RETURN_VALUE)
            Toast.makeText(applicationContext, name, Toast.LENGTH_SHORT).show()
        }
    }

}