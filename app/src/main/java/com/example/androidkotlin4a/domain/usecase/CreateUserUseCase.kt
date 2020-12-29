package com.example.androidkotlin4a.domain.usecase

import com.example.androidkotlin4a.data.repository.UserRepository
import com.example.androidkotlin4a.domain.entity.User

class CreateUserUseCase(private val userRepository: UserRepository) {
    suspend fun invoke(user : User) {
        userRepository.createUser(user)
    }
}