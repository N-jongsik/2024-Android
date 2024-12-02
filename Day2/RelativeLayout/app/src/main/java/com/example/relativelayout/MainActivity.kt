package com.example.relativelayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val leftButton = findViewById<Button>(R.id.leftButton)
        val rightButton = findViewById<Button>(R.id.rightButton)

        leftButton.setOnClickListener {
            val intent = Intent(applicationContext, SecondActivity::class.java)
            intent.putExtra("first direction","left")
            startActivity(intent)
        }

        rightButton.setOnClickListener {
            val intent = Intent(applicationContext, SecondActivity::class.java)
            intent.putExtra("first direction","right")
            startActivity(intent)
        }


    }


}