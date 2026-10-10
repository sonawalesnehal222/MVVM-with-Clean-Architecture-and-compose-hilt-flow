package com.example.mvvmwithcleanproject.data

import com.example.mvvmwithcleanproject.data.dto.remote.ApiService
import com.example.mvvmwithcleanproject.data.mapper.toDomain
import com.example.mvvmwithcleanproject.domain.model.Repository
import com.example.mvvmwithcleanproject.domain.model.UserModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(

    private val apiService: ApiService
) : Repository {
    override fun getUser(): List<UserModel> {

      return apiService.getUser().map { it.toDomain()}
    }
}