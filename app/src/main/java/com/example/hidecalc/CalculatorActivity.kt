package com.example.hidecalc



import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {

    private lateinit var inputField1: EditText
    private lateinit var inputField2: EditText
    private lateinit var addButton: Button
    private lateinit var subtractButton: Button
    private lateinit var multiplyButton: Button
    private lateinit var divideButton: Button
    private lateinit var sendResultButton: Button
    private var result: Double = 0.0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        inputField1 = findViewById(R.id.inputField1)
        inputField2 = findViewById(R.id.inputField2)
        addButton = findViewById(R.id.addButton)
        subtractButton = findViewById(R.id.subtractButton)
        multiplyButton = findViewById(R.id.multiplyButton)
        divideButton = findViewById(R.id.divideButton)
        sendResultButton = findViewById(R.id.sendResultButton)

        addButton.setOnClickListener {
            calculate { a, b -> a + b }
        }

        subtractButton.setOnClickListener {
            calculate { a, b -> a - b }
        }

        multiplyButton.setOnClickListener {
            calculate { a, b -> a * b }
        }

        divideButton.setOnClickListener {
            calculate { a, b -> a / b }
        }

        sendResultButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("result", result.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    private fun calculate(operation: (Double, Double) -> Double) {
        val num1 = inputField1.text.toString().toDoubleOrNull() ?: 0.0
        val num2 = inputField2.text.toString().toDoubleOrNull() ?: 0.0
        result = operation(num1, num2)
    }
}
