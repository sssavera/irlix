package com.example.irlix.network

data class DataNews(
    val results: List<Results>
)

data class Results(
    val title: String,
    val link: String,
    val guid: Int,
    val copyright: String,
    val pubDate: String,
    val description: String,
    val source: String
)
