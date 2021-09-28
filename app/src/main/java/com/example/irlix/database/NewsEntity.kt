package com.example.irlix.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewsEntity (
    @PrimaryKey (autoGenerate = true) val id: Int,
    @ColumnInfo (name = "title") var title: String,
    @ColumnInfo (name = "description") var description: String,
    @ColumnInfo (name = "source") var source: String
        )