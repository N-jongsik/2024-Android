package com.example.relativelayout

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val receivedData = intent.getStringExtra("key")
        
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val buttonUp = findViewById<Button>(R.id.buttonUp)
        val buttonLeft = findViewById<Button>(R.id.buttonLeft)
        val buttonRight = findViewById<Button>(R.id.buttonRight)
        val buttonDown = findViewById<Button>(R.id.buttonDown)

        // 버튼 클릭 시 동작
        buttonUp.setOnClickListener {
            if (receivedData != null) {
                checkAnswer(receivedData, "up")
            }
        }

        // 버튼 클릭 시 동작
        buttonLeft.setOnClickListener {
            if (receivedData != null) {
                checkAnswer(receivedData, "left")
            }
        }

        // 버튼 클릭 시 동작
        buttonRight.setOnClickListener {
            if (receivedData != null) {
                checkAnswer(receivedData, "right")
            }
        }

        // 버튼 클릭 시 동작
        buttonDown.setOnClickListener {
            if (receivedData != null) {
                checkAnswer(receivedData, "down")
            }
        }
    }

    private fun checkAnswer(firstDirection: String, secondDirection: String) {
        val resultIntent = Intent()
        if (firstDirection == "right" && secondDirection == "down") {
            resultIntent.putExtra("result_key", true)
        } else {
            resultIntent.putExtra("result_key", false)
        }
        setResult(Activity.RESULT_OK, resultIntent)
        finish()  // Activity B 종료
    }
}