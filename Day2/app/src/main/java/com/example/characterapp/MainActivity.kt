package com.example.characterapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val iamgeView = findViewById<ImageView>(R.id.imageView)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val radioButton = findViewById<RadioButton>(R.id.radioButton)
        val radioButton2 = findViewById<RadioButton>(R.id.radioButton2)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val button = findViewById<Button>(R.id.button)

        //첫번째 라디오 초기값 설정
        radioButton.isChecked = true
        var character : String = ""


        //라디오 버튼 클릭에 따라 이미지 변경
        // 라디오 그룹에서 선택된 값에 따라 이미지 변경
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radioButton -> {
                    iamgeView.setImageResource(R.drawable.character1) // 커비
                    character = radioButton.text.toString()
                }
                R.id.radioButton2 -> {
                    iamgeView.setImageResource(R.drawable.character2) // 오징어 게임
                    character = radioButton2.text.toString()
                }
            }
        }

        button.setOnClickListener {
            if(checkBox.isChecked){
                showBasicAlert(character)
            }else{
                Toast.makeText(applicationContext,"이용약관에 동의해 주세요.",Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun showBasicAlert(character : String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("${character} 생성 완료")
        //확인 버튼
        builder.setPositiveButton("완료"){dialog, _ ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }
}