package com.example.mvvmwithcleanproject.domain.usecase

import com.example.mvvmwithcleanproject.domain.model.Repository
import com.example.mvvmwithcleanproject.domain.model.UserModel
import javax.inject.Inject

class UserUseCase @Inject constructor(

    private val repository: Repository
) {

    suspend operator fun invoke() : List<UserModel>{

        return repository.getUser()
    }
}