package com.example.androidkotlin4a.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.androidkotlin4a.data.local.models.UserLocal

@Dao
interface DatabaseDao  {
    @Query("SELECT * FROM UserLocal")
    fun getAll(): List<UserLocal>

    @Query("SELECT * FROM UserLocal WHERE first_name LIKE :email LIMIT 1")
    fun findByName(email: String): UserLocal

    @Insert
    fun insert(vararg users: UserLocal)

    @Delete
    fun delete(user: UserLocal)
}