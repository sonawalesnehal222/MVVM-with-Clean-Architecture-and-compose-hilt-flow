package com.example.mvvmwithcleanproject.domain.network

import com.example.mvvmwithcleanproject.data.dto.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModel {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit{


        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesApiService (
        retrofit: Retrofit

    ) : ApiService{

        return retrofit.create(ApiService::class.java)
    }



}