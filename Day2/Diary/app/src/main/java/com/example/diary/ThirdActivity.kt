package com.example.diary

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val list = listOf("12월 23일", "12월 24일", "12월 27일", "12월 29일")

        val listview = findViewById<ListView>(R.id.listView)
        val arrayAdapter = ArrayAdapter<String>(
            this,android.R.layout.simple_list_item_1, list)
        listview.adapter = arrayAdapter
    }
}