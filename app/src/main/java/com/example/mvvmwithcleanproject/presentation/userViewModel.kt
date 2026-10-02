package com.example.mvvmwithcleanproject.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmwithcleanproject.domain.model.UserModel
import com.example.mvvmwithcleanproject.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(

    private val userUseCase: UserUseCase
) : ViewModel() {

    var _user = MutableStateFlow<List<UserModel>>(emptyList())

    var user:StateFlow<List<UserModel>> = _user


    fun getUser(){


        viewModelScope.launch {

            _user.value = userUseCase()
        }


    }


}