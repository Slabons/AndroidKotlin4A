package com.example.androidkotlin4a.data.repository

import com.example.androidkotlin4a.data.local.DatabaseDao
import com.example.androidkotlin4a.data.local.models.toData
import com.example.androidkotlin4a.data.local.models.toEntity
import com.example.androidkotlin4a.domain.entity.User

class UserRepository(private val databaseDao: DatabaseDao) {

    suspend fun createUser(user : User) {
        databaseDao.insert(user.toData())
    }

    fun getUser(email: String): User? {
       val userLocal = databaseDao.findByName(email)
        return userLocal?.toEntity()
    }
}