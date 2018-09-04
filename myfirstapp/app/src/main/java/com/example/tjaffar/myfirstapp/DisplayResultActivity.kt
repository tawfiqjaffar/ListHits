package com.example.tjaffar.myfirstapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class DisplayResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_result)

        val result = intent.getStringExtra(EXTRA_RESULT)
        val viewRes = findViewById<TextView>(R.id.textViewResult)

        viewRes.text = result
    }
}
