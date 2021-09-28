package com.example.irlix

import com.example.irlix.database.NewsDao
import com.example.irlix.database.NewsEntity
import io.reactivex.Flowable

class NewsRepository(private val newsDao: NewsDao) {
    val all: Flowable<List<NewsEntity>> = newsDao.getAll()

    suspend fun insert(news: NewsEntity) {
        newsDao.insert(news)
    }
}