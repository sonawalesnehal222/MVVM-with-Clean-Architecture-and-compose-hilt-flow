package com.example.mvvmwithcleanproject.domain.network

import com.example.mvvmwithcleanproject.data.RepositoryImpl
import com.example.mvvmwithcleanproject.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

     @Binds
     abstract fun ProvideRepository(
         repositoryImpl: RepositoryImpl
     ) : Repository
}