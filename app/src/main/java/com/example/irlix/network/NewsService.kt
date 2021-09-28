package com.example.irlix.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object NewsService {
    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
//      .baseUrl("https://news.google.com/rss/search?q=apple&hl=ru&gl=RU&ceid=RU:ru")
        .baseUrl("https://news.google.com/rss/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun<T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}