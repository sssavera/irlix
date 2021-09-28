package com.example.irlix.database

import androidx.room.*
import io.reactivex.Flowable

@Dao
interface NewsDao {
    @Query("SELECT * FROM news ORDER BY title ASC" )
    fun getAll(): Flowable<List<NewsEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(news: NewsEntity)

    @Delete
    suspend fun delete(news: NewsEntity)
}
