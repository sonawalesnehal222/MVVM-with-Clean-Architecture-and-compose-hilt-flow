package com.example.mvvmwithcleanproject.domain.usecase

import com.example.mvvmwithcleanproject.domain.model.UserModel
import com.example.mvvmwithcleanproject.domain.repository.Repository
import javax.inject.Inject

class UserUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend operator fun invoke(): List<UserModel>{

        return repository.getUser()
    }
}