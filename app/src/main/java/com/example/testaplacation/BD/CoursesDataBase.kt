package com.example.testaplacation.BD

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CourseCache::class, CashCache::class], version = 1)
abstract class CoursesDataBase : RoomDatabase() {
    abstract fun courseDao(): CoursesDao
    abstract fun cashDao(): CashDao
}