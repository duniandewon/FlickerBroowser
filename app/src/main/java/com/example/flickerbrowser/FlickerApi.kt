package com.example.flickerbrowser

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickerApi {

    @GET("/")
    suspend fun getImages(
        @Query("format") format: String,
        @Query("nojsoncallback") nojsoncallback: String
    ): Response<FlickerResponse>

}