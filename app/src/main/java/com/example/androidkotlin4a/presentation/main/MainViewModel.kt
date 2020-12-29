package com.example.androidkotlin4a

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidkotlin4a.domain.usecase.CreateUserUseCase
import com.example.androidkotlin4a.domain.entity.User
import com.example.androidkotlin4a.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
    private  val createUserUseCase: CreateUserUseCase,
    private val  getUserUseCase: GetUserUseCase
) : ViewModel() {

    val counter : MutableLiveData<Int> = MutableLiveData()

    init {
        counter.value = 0
    }

    fun onClickedIncrement(emailUser: String) {

        viewModelScope.launch(Dispatchers.IO) {
            createUserUseCase.invoke(User(email = "test"))
            delay(1000)
            val user = getUserUseCase.invoke("test")
        }
    }
}