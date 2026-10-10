package com.example.mvvmwithcleanproject.data.dto.remote

import com.example.mvvmwithcleanproject.data.dto.UserDto
import retrofit2.http.GET

interface ApiService {


    @GET("users")
    fun getUser() : List<UserDto>
}