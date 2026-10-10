package com.example.mvvmwithcleanproject.presentation

import com.example.mvvmwithcleanproject.domain.model.UserModel
import com.example.mvvmwithcleanproject.domain.usecase.UserUseCase
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.mockito.kotlin.mock


@OptIn(ExperimentalCoroutinesApi::class)
class UserViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var userUseCase: UserUseCase
    private lateinit var viewModel: UserViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)

        userUseCase = mock()
        viewModel = UserViewModel(userUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial user state should be empty`() {
        assertEquals(emptyList<UserModel>(), viewModel.user.value)
    }

    @Test
    fun `getUserData should update user state`() = runTest {
        // Arrange
        val users = listOf(
            UserModel(
                id = 1,
                name = "John",
                email = "john@gmail.com",
                street = "ABC Street",
                city = "Pune"
            )
        )

        whenever(userUseCase()).thenReturn(users)

        // Act
        viewModel.getUSerData()
        advanceUntilIdle()

        // Assert
        assertEquals(users, viewModel.user.value)
        verify(userUseCase).invoke()
    }

    @Test
    fun `getUserData should handle empty user list`() = runTest {
        // Arrange
        whenever(userUseCase()).thenReturn(emptyList())

        // Act
        viewModel.getUSerData()
        advanceUntilIdle()

        // Assert
        assertTrue(viewModel.user.value.isEmpty())
        verify(userUseCase).invoke()
    }

}