package com.tjaffar.listhits

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

var lang_global : String = ""

interface Network {
    @GET("api.php")
    fun getHits(@Query("action") action:String,
                @Query("format") format: String,
                @Query("list") list: String,
                @Query("srsearch") srsearch: String) : Call<QueryResults>
    companion object {
        fun createRetroFitInstance(lang : String): Network {
            var url = ""
            if (lang == "FR") {
                lang_global = "FR"
                url = "http://fr.wikipedia.org/w/"
            } else {
                lang_global = "EN"
                url = "http://en.wikipedia.org/w/"
            }

            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(url)
                    .build()
            return (retrofit.create(Network::class.java))
        }
    }
}