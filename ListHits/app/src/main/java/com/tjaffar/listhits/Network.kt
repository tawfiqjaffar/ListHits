package com.tjaffar.listhits

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Network {
    @GET("api.php")
    fun getHits(@Query("action") action:String,
                @Query("format") format: String,
                @Query("list") list: String,
                @Query("srsearch") srsearch: String) : Call<QueryResults>
    companion object {
        fun createRetroFitInstance(): Network {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://en.wikipedia.org/w/")
                    .build()
            return (retrofit.create(Network::class.java))
        }
    }
}