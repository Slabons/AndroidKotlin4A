package com.example.androidkotlin4a.injection.injection

import com.example.androidkotlin4a.MainViewModel
import org.koin.dsl.module

val presentationModule = module {

    factory { MainViewModel() }
}