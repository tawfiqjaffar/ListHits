package com.example.tjaffar.myfirstapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

const val EXTRA_RESULT = "com.example.tjaffar.myfirstapp.RESULT"

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
            "%" -> if (y == 0.toDouble()) (-1).toDouble() else x % y
            "/" -> if (y == 0.toDouble()) (-1).toDouble() else x / y
            else -> 0.toDouble()
        }
    }

    fun compute(view: View) {
        val editTextNum1 = findViewById<EditText>(R.id.editTextNum1)
        val editTextNum2 = findViewById<EditText>(R.id.editTextNum2)
        Log.d("debug", "here")

        if (editTextNum1.text.toString().trim().isEmpty() ||
                editTextNum2.text.toString().trim().isEmpty()) {
            Toast.makeText(this@MainActivity, "Operands can't be empty", Toast.LENGTH_LONG).show()
        } else {
            val num1 = findViewById<EditText>(R.id.editTextNum1).text.toString().toDouble()
            val num2 = findViewById<EditText>(R.id.editTextNum2).text.toString().toDouble()
            val op = getOperator()
            val intent = Intent(this, DisplayResultActivity::class.java)

            intent.apply {
                putExtra(EXTRA_RESULT, doOperation(num1, num2, op).toString())
            }
            startActivity(intent)
        }
    }


}
