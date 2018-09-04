package com.example.tjaffar.myfirstapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

const val EXTRA_MESSAGE = "com.example.tjaffar.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun compute(view: View) {
        val num1 = findViewById<EditText>(R.id.editTextNum1)
        val num2 = findViewById<EditText>(R.id.editTextNum2)
    }
}
