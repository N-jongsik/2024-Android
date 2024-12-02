package com.jongsik.memoapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jongsik.memoapp2.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val editText: EditText = findViewById(R.id.editText)
//
//        val listView : ListView = findViewById(R.id.listView)
//
//
//        val arrayList: ArrayList<String> = ArrayList<String>()
//        arrayList.add("정신차리기")
//        arrayList.add("정신차리기")
//        arrayList.add("정신차리기")
//
//        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList)
//
//
//        val button: Button = findViewById(R.id.button)
//        button.setOnClickListener {
//            arrayList.add(editText.text.toString())
//        }

        val editText1 = findViewById<EditText>(R.id.editText1)


    }
}