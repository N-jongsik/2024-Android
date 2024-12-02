package com.example.diary

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val gotoSecond = findViewById<ImageView>(R.id.imageView)

        gotoSecond.setOnClickListener {
            val intent = Intent(applicationContext, SecondActivity::class.java)
            intent.putExtra("first direction","goto Second")
            startActivity(intent)
        }
    }
}