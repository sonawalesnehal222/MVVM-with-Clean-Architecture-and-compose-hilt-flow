package com.example.mvvmwithcleanproject.data.remote

import com.example.mvvmwithcleanproject.data.dto.UserDto
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUser():List<UserDto>
}