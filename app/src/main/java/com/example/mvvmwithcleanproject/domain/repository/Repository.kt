package com.example.mvvmwithcleanproject.domain.repository

import com.example.mvvmwithcleanproject.domain.model.UserModel

interface Repository {

    suspend fun getUser():List<UserModel>
}