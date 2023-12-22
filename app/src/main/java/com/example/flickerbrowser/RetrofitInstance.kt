package com.example.flickerbrowser

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {
    val api: FlickerApi by lazy {
        Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(FlickerApi::class.java)
    }
}