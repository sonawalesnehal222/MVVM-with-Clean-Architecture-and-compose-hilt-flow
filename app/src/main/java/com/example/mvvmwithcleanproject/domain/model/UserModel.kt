package com.example.mvvmwithcleanproject.domain.model

import com.example.mvvmwithcleanproject.data.dto.AddressDto

data class UserModel(
    val id:Int,
    val name:String,
    val email:String,
    val street : String,
    val city: String
)
