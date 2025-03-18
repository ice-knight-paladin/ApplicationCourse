package com.example.testaplacation.BD

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course_table")
data class CourseCache(
    @PrimaryKey @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "text") var text: String,
    @ColumnInfo(name = "price") var price: String,
    @ColumnInfo(name = "rate") var rate: String,
    @ColumnInfo(name = "startDate") var startDate: String,
    @ColumnInfo(name = "hasLike") var hasLike: String,
    @ColumnInfo(name = "publishDate") var publishDate: String,
)

@Entity(tableName = "cash_table")
data class CashCache(
    @PrimaryKey @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "text") val text: String
)