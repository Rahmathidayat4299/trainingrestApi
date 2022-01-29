package com.example.restapi

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    fun getPost(): Call<MutableList<PostModel>>
}