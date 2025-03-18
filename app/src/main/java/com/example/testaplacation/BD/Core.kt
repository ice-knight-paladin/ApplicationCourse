package com.example.testaplacation.BD

import android.content.Context
import androidx.room.Room

class Core(
    private val context: Context
) {
    private val dataBase by lazy {
        Room.databaseBuilder(
            context,
            CoursesDataBase::class.java,
            "items_database_multi"
        )
            .addMigrations(MIGRATION_1_2)
            .build()
    }

    fun courseDao() = dataBase.courseDao()
    fun cashDao() = dataBase.cashDao()
}