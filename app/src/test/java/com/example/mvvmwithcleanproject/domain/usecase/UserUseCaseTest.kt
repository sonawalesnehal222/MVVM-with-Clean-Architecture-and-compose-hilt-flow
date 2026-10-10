package com.example.mvvmwithcleanproject.domain.usecase

import com.example.mvvmwithcleanproject.domain.model.Repository
import com.example.mvvmwithcleanproject.domain.model.UserModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever


class UserUseCaseTest {

    private val repository : Repository = mock()
    private val userUseCase = UserUseCase(repository)


    @Test
    fun `should return user from repository`() {
        runTest {


            val user = listOf(
                UserModel(

                    id = 123,
                    name = "snehal",
                    email = "abc@gmail",
                    street = "main road",
                    city = "Pune"
                )
            )

            whenever(repository.getUser()).thenReturn(user)

            val result = userUseCase()

            assertEquals(user, result)

        }
    }
}