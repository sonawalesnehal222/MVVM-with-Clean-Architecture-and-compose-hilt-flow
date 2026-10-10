package com.example.mvvmwithcleanproject.data.mapper

import com.example.mvvmwithcleanproject.data.dto.Address
import com.example.mvvmwithcleanproject.data.dto.UserDto
import com.example.mvvmwithcleanproject.domain.model.UserModel
import org.junit.Assert.assertEquals
import org.junit.Test


class UserMapperTest {

    @Test
    fun `dto should map correctly`(){

        val userDto = UserDto(

            id = 123,
            name = "snehal",
            email = "abc@gmail",
            address = Address(
                street = "main road",
                city = "Pune"
            )
        )

        val result = userDto.toDomain()

        val expected = UserModel(
            id = 123,
            name = "snehal",
            email = "abc@gmail",
            street = "main road",
            city = "Pune"

        )

        assertEquals(result,expected)
    }

}