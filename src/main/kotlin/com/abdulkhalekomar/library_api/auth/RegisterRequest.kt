package com.abdulkhalekomar.library_api.auth

import jakarta.validation.constraints.Digits
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class RegisterRequest(
	@get:NotBlank @get:Size(min = 2, max = 100) val firstName: String?,
	@get:NotBlank @get:Size(min = 2, max = 150) val lastName: String?,
	@get:Digits(integer = 15, fraction = 0) val phone: String?,
	@get:Email val email: String?,
	@get:Size(min = 8, max = 255) val password: String?,
)
