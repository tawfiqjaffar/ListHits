package com.tjaffar.listhits

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Adapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_list_results_display.*
import kotlinx.android.synthetic.main.activity_list_results_display.recyclerResults
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListResultsDisplay : AppCompatActivity() {

    private val api = Network.createRetroFitInstance()
    private val tool = Tools.create()
    val list : ArrayList<SearchInfoList> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_results_display)
        val queryString = intent.getStringExtra(EXTRA_QUERY)

        val test = SearchInfoList("This is a test",
                                "some timestamp",
                                "Some snipptet",
                                1239123,
                                1231)

        list.add(test)

        getResponses(queryString)
        tool.printf(list.size.toString())

        recyclerResults.layoutManager = LinearLayoutManager(this)
        recyclerResults.adapter = ResultsAdapter(list, this)
    }

    private fun getResponses(queryString : String) {
        val call = api.getHits("query", "json", "search", queryString)

        call.enqueue(object: Callback<QueryResults> {
            override fun onResponse(call: Call<QueryResults>, response: Response<QueryResults>) {
                val results = response.body()

                for (hit in results!!.query!!.search!!) {
                    val temp = hit
                    list.add(temp)
                }
                //displayTitles(resultString)
            }
            override fun onFailure(call: Call<QueryResults>, t: Throwable) {
                tool.printf(t.message.toString())
            }
        })
    }

//    private fun displayTitles(string: String) {
//        tool.printf(string.length.toString())
//        val resultText = findViewById<TextView>(R.id.textViewListResults)
//
//        resultText.text = string
//    }
}
