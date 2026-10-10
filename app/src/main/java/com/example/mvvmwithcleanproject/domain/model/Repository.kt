package com.example.mvvmwithcleanproject.domain.model

interface Repository {


    fun getUser() : List<UserModel>
}