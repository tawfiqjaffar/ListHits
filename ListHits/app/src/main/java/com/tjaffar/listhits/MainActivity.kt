package com.tjaffar.listhits

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val EXTRA_QUERY = "com.tjaffar.listhits.QUERY"
const val EXTRA_ITEM = "com.tjaffar.listhits.ITEM"

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonGo(view: View) {
        val queryString = findViewById<EditText>(R.id.editTextQuery).text

        if (queryString.toString().trim().isEmpty()) {
            Toast.makeText(this@MainActivity, "Query must not be empty", Toast.LENGTH_LONG).show()
        } else {
            val intent = Intent(this, ListResultsDisplay::class.java).apply {
                putExtra(EXTRA_QUERY, queryString.toString().trim())
            }
            startActivity(intent)
        }
    }

//    fun buttonGo(view: View) {
//        val queryString = findViewById<EditText>(R.id.editTextQuery).text
//        val resultText = findViewById<TextView>(R.id.textViewResult)
//        val call = api.getHits("query", "json",
//                "search", queryString.toString())
//
//        call.enqueue(object: Callback<QueryResults> {
//            override fun onResponse(call: Call<QueryResults>, response: Response<QueryResults>) {
//                val results = response.body()
//
//                for (hit in results!!.query!!.search!!) {
//                    val debugString = "%s\tid:%d\n%s".format(hit.title, hit.pageid,
//                            android.text.Html.fromHtml(hit.snippet))
//
//                    tool.printf(debugString)
//                }
//
//            }
//            override fun onFailure(call: Call<QueryResults>, t: Throwable) {
//                Log.d("LOG", t.message.toString())
//            }
//        })
//    }
}
