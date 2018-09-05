package com.tjaffar.apitest2

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Network {

    @GET("api.php")
    fun getNumberOfHits(@Query("action") action: String,
                        @Query("format") format: String,
                        @Query("list") list: String,
                        @Query("srsearch") srsearch: String) : Call<Model.Result>


    companion object {
        fun createRetroFitInstance(): Network {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://en.wikipedia.org/w/")
                    .build()
            return (retrofit.create(Network::class.java))
        }
    }
//    @GET("api.php")
//    fun hitCountCheck(@Query("action") action: String,
//                      @Query("format") format: String,
//                      @Query("list") list: String,
//                      @Query("srsearch") srsearch: String): Observable<Model.Result>
//    companion object {
//        fun create(): Network {
//
//            val retrofit = Retrofit.Builder()
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .baseUrl("https://en.wikipedia.org/w/")
//                    .build()
//
//            return retrofit.create(Network::class.java)
//        }
//    }

}