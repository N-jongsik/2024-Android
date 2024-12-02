package com.example.reservation

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var location: String = ""
    var date: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val buttonDate = findViewById<Button>(R.id.buttonDate)
        val buttonBook = findViewById<Button>(R.id.buttonBook)

        val locationList = listOf(
            "서울", "양양", "대전", "부산", "청주"
        )

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, locationList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>, p1: View?, p2: Int, p3: Long) {
                location = p0!!.getItemAtPosition(p2).toString()
                Toast.makeText(applicationContext, location, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>) {

            }
        }
        buttonDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val dataPickerDialog =
                DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                    date = "$selectedDay/${selectedMonth + 1} / $selectedYear"
                    buttonDate.text = date
                }, year, month, day)
            dataPickerDialog.show();

        }
    }
}