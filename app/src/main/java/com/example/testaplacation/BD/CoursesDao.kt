package com.example.testaplacation.BD

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface CoursesDao {
    @Query("SELECT * FROM course_table")
    fun list(): List<CourseCache>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(item: CourseCache)

    @Update
    fun update(item: CourseCache)

    @Query("DELETE FROM course_table WHERE id = :id")
    fun delete(id: Long)

    @Query("SELECT * FROM course_table WHERE id = :id")
    fun item(id: Long): CourseCache

    @Query("DELETE FROM course_table")
    fun clear_table()
}

@Dao
interface CashDao {
    @Query("SELECT * FROM cash_table")
    fun list(): List<CashCache>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(item: CashCache)

    @Update
    fun update(item: CashCache)

    @Query("DELETE FROM cash_table WHERE id = :id")
    fun delete(id: Long)

    @Query("SELECT * FROM cash_table WHERE id = :id")
    fun item(id: Long): CashCache

    @Query("DELETE FROM cash_table")
    fun clear_table()
}