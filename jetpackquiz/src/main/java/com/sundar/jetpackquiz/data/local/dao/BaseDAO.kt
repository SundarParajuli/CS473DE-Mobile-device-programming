package com.sundar.jetpackquiz.data.local.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDAO<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj: T): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj: List<T>): List<Long>

    @Update
    suspend fun update(obj: T): Int

    @Update
    suspend fun update(obj: List<T>): Int

    @Delete
    suspend fun delete(obj: T): Int

    @Delete
    suspend fun delete(obj: List<T>): Int
}