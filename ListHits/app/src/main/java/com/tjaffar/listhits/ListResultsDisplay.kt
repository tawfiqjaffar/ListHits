package com.tjaffar.listhits

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListResultsDisplay : AppCompatActivity() {

    private lateinit var api : Network
    private val tool = Tools.create()
    lateinit var recyclerResults : RecyclerView
    lateinit var loadingSpinner : ProgressBar
    val list : ArrayList<SearchInfoList> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_results_display)

        api = Network.createRetroFitInstance(intent.getStringExtra(EXTRA_EN_FR))
        val queryString : String = intent.getStringExtra(EXTRA_QUERY)

        loadingSpinner = findViewById(R.id.loadingSpinner)
        loadingSpinner.visibility = View.VISIBLE
        recyclerResults = findViewById(R.id.recyclerResults)
        getResponses(queryString)
        tool.printf(list.size.toString())
        recyclerResults.layoutManager = LinearLayoutManager(this)
        recyclerResults.adapter = ResultsAdapter(list, this)
    }

    private fun getResponses(queryString : String) {
        val call = api.getHits("query", "json", "search", queryString)

        call.enqueue(object: Callback<QueryResults> {
            override fun onResponse(call: Call<QueryResults>, response: Response<QueryResults>) {
                loadingSpinner.visibility = View.GONE
                val results = response.body()

                for (hit in results!!.query!!.search!!) {
                    list.add(hit)
                }
                recyclerResults.adapter!!.notifyDataSetChanged()
            }
            override fun onFailure(call: Call<QueryResults>, t: Throwable) {
                tool.printf(t.message.toString())
            }
        })
    }
}
