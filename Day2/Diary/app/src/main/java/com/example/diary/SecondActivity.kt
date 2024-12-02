package com.example.diary

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val sunny = findViewById<ImageView>(R.id.sunny)
        val sunnyCloud = findViewById<ImageView>(R.id.sunnyCloud)
        val cloud = findViewById<ImageView>(R.id.cloud)
        val rainy = findViewById<ImageView>(R.id.rainy)
        val snow = findViewById<ImageView>(R.id.snow)

        val weatherIcons = listOf(sunny, sunnyCloud, cloud, rainy, snow)

        // 모든 아이콘을 클릭했을 때 처리
        weatherIcons.forEach { icon ->
            icon.setOnClickListener {
                // 선택된 아이콘에 테두리 적용
                weatherIcons.forEach { it.setBackgroundResource(R.drawable.border_unselected) }
                icon.setBackgroundResource(R.drawable.border_selected)
            }
        }

        val gotoThird = findViewById<Button>(R.id.button)

        gotoThird.setOnClickListener {
            val intent = Intent(applicationContext, ThirdActivity::class.java)
            intent.putExtra("first direction","goto Second")
            startActivity(intent)
        }
    }
}