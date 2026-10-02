package com.example.mvvmwithcleanproject.data

import com.example.mvvmwithcleanproject.data.mapper.toDomain
import com.example.mvvmwithcleanproject.data.remote.ApiService
import com.example.mvvmwithcleanproject.domain.model.UserModel
import com.example.mvvmwithcleanproject.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(

    private val apiService: ApiService
): Repository {
    override suspend fun getUser(): List<UserModel> {
        return apiService.getUser().map { it.toDomain() }
    }
}