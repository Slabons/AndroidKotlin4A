package com.example.androidkotlin4a

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidkotlin4a.domain.usecase.CreateUserUseCase
import com.example.androidkotlin4a.domain.entity.User
import com.example.androidkotlin4a.domain.usecase.GetUserUseCase
import com.example.androidkotlin4a.presentation.main.LoginError
import com.example.androidkotlin4a.presentation.main.LoginStatus
import com.example.androidkotlin4a.presentation.main.LoginSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private  val createUserUseCase: CreateUserUseCase,
    private val  getUserUseCase: GetUserUseCase
) : ViewModel() {

    val loginlivedata : MutableLiveData<LoginStatus> = MutableLiveData()


    fun onClickedLogin(emailUser: String, password: String) {

        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(emailUser)
            val loginStatus = if (user != null) {
                LoginSuccess(user.email)
            }else {
                LoginError
            }

            withContext(Dispatchers.Main) {
                loginlivedata.value = loginStatus
            }
        }
    }
}