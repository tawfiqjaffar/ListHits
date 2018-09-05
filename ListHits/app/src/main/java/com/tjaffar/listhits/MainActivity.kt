package com.tjaffar.listhits

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val api = Network.createRetroFitInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonGo(view: View) {
        val queryString = findViewById<EditText>(R.id.editTextQuery).text
        val resultText = findViewById<TextView>(R.id.textViewResult)
        val call = api.getHits("query", "json",
                "search", queryString.toString())

        call.enqueue(object: Callback<QueryResults> {
            override fun onResponse(call: Call<QueryResults>, response: Response<QueryResults>) {
                val results = response.body()
                
            }
            override fun onFailure(call: Call<QueryResults>, t: Throwable) {
                Log.d("LOG", t.message.toString())
            }
        })
    }
}
