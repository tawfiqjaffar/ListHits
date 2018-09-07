package com.tjaffar.listhits

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast

const val EXTRA_QUERY = "com.tjaffar.listhits.QUERY"
const val EXTRA_ITEM = "com.tjaffar.listhits.ITEM"
const val EXTRA_EN_FR = "com.tjaffar.listhits.ENFR"

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonGo(view: View) {
        val queryString = findViewById<EditText>(R.id.editTextQuery).text
        val switchEnFr = findViewById<Switch>(R.id.switchFrEn)

        if (queryString.toString().trim().isEmpty()) {
            Toast.makeText(this@MainActivity, "Query must not be empty", Toast.LENGTH_LONG).show()
        } else {
            val intent = Intent(this, ListResultsDisplay::class.java).apply {
                putExtra(EXTRA_QUERY, queryString.toString().trim())
                if (switchEnFr.isChecked)
                    putExtra(EXTRA_EN_FR, "EN")
                else
                    putExtra(EXTRA_EN_FR, "FR")
            }
            startActivity(intent)
        }
    }
}
