package com.abdulkhalekomar.library_api.user

import com.abdulkhalekomar.library_api.address.Address
import jakarta.validation.constraints.Digits
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UserRequest(
	@get:NotBlank @get:Size(min = 2, max = 100) val firstName: String?,
	@get:NotBlank @get:Size(min = 2, max = 150) val lastName: String?,
	@get:Digits(integer = 15, fraction = 0) val phone: String?,
	@get:Email val email: String?,
	val address: Address?,
)

data class UserResponse(
	val id: Long?,
)

fun UserRequest.toEntity() = User(
	firstName = firstName,
	lastName = lastName,
	phone = phone,
	email = email,
	address = address,
)

fun User.toResponse() = UserResponse(
	id = id,
)
