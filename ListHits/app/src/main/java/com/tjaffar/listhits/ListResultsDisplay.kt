package com.tjaffar.listhits

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListResultsDisplay : AppCompatActivity() {

    private val api = Network.createRetroFitInstance()
    private val tool = Tools.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_results_display)
        val queryString = intent.getStringExtra(EXTRA_QUERY)

        getResponses(queryString)
    }

    private fun getResponses(queryString : String) {
        val call = api.getHits("query", "json", "search", queryString)

        call.enqueue(object: Callback<QueryResults> {
            override fun onResponse(call: Call<QueryResults>, response: Response<QueryResults>) {
                val results = response.body()
                var resultString = ""

                for (hit in results!!.query!!.search!!) {
                    resultString += "%s\n".format(hit.title)
                }
                displayTitles(resultString)

            }
            override fun onFailure(call: Call<QueryResults>, t: Throwable) {
                tool.printf(t.message.toString())
            }
        })
    }

    private fun displayTitles(string: String) {
        tool.printf(string.length.toString())
        val resultText = findViewById<TextView>(R.id.textViewListResults)

        resultText.text = string
    }
}
