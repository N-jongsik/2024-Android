package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

enum class Arithmetic(val symbol: String) {
    ADD("+"),
    SUB("-"),
    MULT("*"),
    DIV("/");
}

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView

    // 사칙연산 부호 클릭 여부
    var arithmetic: Arithmetic? = null
    var a: Int = 0 // 첫 번째 정수
    var b: Int = 0 // 두 번째 정수

    // 디스플레이 할 정수
    var displayA: String = ""
    var displayB: String = ""

    var equal: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        textView = findViewById<TextView>(R.id.textView)

        //숫자 버튼
        val button0 = findViewById<Button>(R.id.button0)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)

        //기능 버튼
        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val buttonMinus = findViewById<Button>(R.id.buttonMinus)
        val buttonMul = findViewById<Button>(R.id.buttonMul)
        val buttonDiv = findViewById<Button>(R.id.buttonDiv)
        val buttonEqual = findViewById<Button>(R.id.buttonEqual)
        val buttonInit = findViewById<Button>(R.id.buttonC)

        button0.setOnClickListener {view ->
            setNumberKeypadClicked((view as Button).text.toString())
        }
        button1.setOnClickListener {view ->
            setNumberKeypadClicked((view as Button).text.toString())
        }
        button2.setOnClickListener {view ->
            setNumberKeypadClicked((view as Button).text.toString())
        }
        button3.setOnClickListener {view ->
            setNumberKeypadClicked((view as Button).text.toString())
        }
        button4.setOnClickListener {view ->
            setNumberKeypadClicked((view as Button).text.toString())
        }
        button5.setOnClickListener {view ->
            setNumberKeypadClicked((view as Button).text.toString())
        }
        button6.setOnClickListener {view ->
            setNumberKeypadClicked((view as Button).text.toString())
        }
        button7.setOnClickListener {view ->
            setNumberKeypadClicked((view as Button).text.toString())
        }
        button8.setOnClickListener {view ->
            setNumberKeypadClicked((view as Button).text.toString())
        }
        button9.setOnClickListener {view ->
            setNumberKeypadClicked((view as Button).text.toString())
        }

        //사칙연산 버튼
        buttonAdd.setOnClickListener { view ->
            setArithmeticClicked((view as Button).text.toString())
        }
        buttonMinus.setOnClickListener { view ->
            setArithmeticClicked((view as Button).text.toString())
        }
        buttonMul.setOnClickListener { view ->
            setArithmeticClicked((view as Button).text.toString())
        }
        buttonDiv.setOnClickListener { view ->
            setArithmeticClicked((view as Button).text.toString())
        }

        //equal버튼
        buttonEqual.setOnClickListener {
            val result = when(arithmetic){
                Arithmetic.ADD -> displayA.toInt() + displayB.toInt()
                Arithmetic.SUB -> displayA.toInt() - displayB.toInt()
                Arithmetic.MULT -> displayA.toInt() * displayB.toInt()
                Arithmetic.DIV -> displayA.toInt() / displayB.toInt()
                null -> {}
            }

            textView.text = textView.text.toString() + " = " + result.toString()
        }

        buttonInit.setOnClickListener {
            textView.text = ""
            arithmetic = null
            displayA = ""
            displayB = ""
        }


    }


    //숫자 키패드 클릭 시 수행 함수
    fun setNumberKeypadClicked(number: String){
        if(arithmetic == null){
            displayA = displayA + number
            textView.text = displayA
        }else{
            displayB = displayB + number
            textView.text = displayA + "${arithmetic!!.symbol}" + displayB
        }
    }

    // 사칙연산 부호 클릭 시 실행 함수
    fun setArithmeticClicked(symbol: String) {
        when (symbol) {
            "+" -> arithmetic = Arithmetic.ADD
            "-" -> arithmetic = Arithmetic.SUB
            "*" -> arithmetic = Arithmetic.MULT
            "/" -> arithmetic = Arithmetic.DIV
        }

        textView.text = textView.text.toString() + " " + symbol
    }
}