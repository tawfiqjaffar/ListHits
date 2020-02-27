package com.tjaffar.apitest2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import io.reactivex.disposables.Disposable
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val api_test = Network.createRetroFitInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonGo(view: View) {
        val queryString = findViewById<EditText>(R.id.editTextQuery).text
        val resultText = findViewById<TextView>(R.id.textViewResult)
        val call = api_test.getNumberOfHits("query", "json",
                "search", queryString.toString())

        call.enqueue(object: Callback<Model.Result> {
            override fun onResponse(call: Call<Model.Result>, response: Response<Model.Result>) {
                val results = response.body()

                resultText.text = results!!.query.searchinfo.totalhits.toString()
            }
            override fun onFailure(call: Call<Model.Result>, t: Throwable) {
                Log.d("LOG", t.message.toString())
            }
        })
    }
}
