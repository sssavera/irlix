package com.example.irlix.network

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface NewsInterface {
    @GET("search?")
    fun getNews(@Query("q=apple") q: String, @Query ("hl=ru") hl: String, @Query ("gl=RU") gl: String, @Query ("ceid=RU:ru") ceid: String): Call<DataNews>
}