package com.example.testaplacation.BD

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("CREATE TABLE IF NOT EXISTS `course_table` (`id` INTEGER NOT NULL, `title` TEXT NOT NULL, `text` TEXT NOT NULL, `price` TEXT NOT NULL, 'rate' TEXT NOT NULL, 'startDate' TEXT NOT NULL, 'hasLike' TEXT NOT NULL, 'publishDate' TEXT NOT NULL, PRIMARY KEY(`id`))")
        database.execSQL("CREATE TABLE IF NOT EXISTS `cash_table` (`id` INTEGER NOT NULL, `text` TEXT NOT NULL, PRIMARY KEY(`id`))")
    }
}