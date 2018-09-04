package com.example.tjaffar.myfirstapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun getOperator() : String {
        val myOp = findViewById<Spinner>(R.id.spinnerOperators)

        return myOp.selectedItem.toString()
    }

    private fun doOperation(x: Double, y: Double, op: String) : Double {
        return when (op) {
            "+" -> x + y
            "-" -> x - y
            "*" -> x * y
            "/" -> if (y == 0.toDouble()) (-1).toDouble() else x / y
            else -> 0.toDouble()
        }
    }
    fun compute(view: View) {
        val editTextNum1 = findViewById<EditText>(R.id.editTextNum1)
        val editTextNum2 = findViewById<EditText>(R.id.editTextNum2)

        if (editTextNum1.text.toString().trim().isEmpty() ||
                editTextNum2.text.toString().trim().isEmpty()) {
            Log.d("Error", "operand is null")
            Toast.makeText(this@MainActivity, "Operands can't be empty", Toast.LENGTH_LONG).show()
        } else {
            val num1 = findViewById<EditText>(R.id.editTextNum1).text.toString().toDouble()
            val num2 = findViewById<EditText>(R.id.editTextNum2).text.toString().toDouble()
            val viewRes = findViewById<TextView>(R.id.textViewResult)
            val op = getOperator()

            viewRes.text = doOperation(num1, num2, op).toString()
        }
    }


}
