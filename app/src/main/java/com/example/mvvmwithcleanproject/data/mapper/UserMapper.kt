package com.example.mvvmwithcleanproject.data.mapper

import com.example.mvvmwithcleanproject.data.dto.UserDto
import com.example.mvvmwithcleanproject.domain.model.UserModel

fun UserDto.toDomain() : UserModel{

    return UserModel(
        id = id,
        name = name,
        email = email,
        street = address.street,
        city = address.city

    )
}