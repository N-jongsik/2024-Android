package com.example.stopwatch

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var time = 10.0
    private val lap = mutableListOf<String>()
    private var running = false
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lap)
        listView.adapter = adapter

        val textView =findViewById<TextView>(R.id.textView)
        val buttonStart = findViewById<Button>(R.id.buttonStart)
        val buttonPause = findViewById<Button>(R.id.buttonPause)
        val buttonReset = findViewById<Button>(R.id.buttonReset)
        val buttonLap = findViewById<Button>(R.id.buttonLap)

        handler = Handler(Looper.getMainLooper())

        runnable = object : Runnable {
            override fun run() {
                if(running){
                    time -= 0.01
                    textView.text = String.format("%.2f",time)
                    handler.postDelayed(this, 10)
                }
            }
        }

        buttonStart.setOnClickListener {
            running = true
            handler.post(runnable)
        }

        buttonPause.setOnClickListener {
            running = false
        }

        buttonReset.setOnClickListener {
            running = false
            time = 0.0
            textView.text = String.format("%.2f",time)
            lap.clear()
            adapter.notifyDataSetChanged()
        }

        buttonLap.setOnClickListener {
            lap.add(String.format("%.2f",time))
            adapter.notifyDataSetChanged()
        }
    }
}