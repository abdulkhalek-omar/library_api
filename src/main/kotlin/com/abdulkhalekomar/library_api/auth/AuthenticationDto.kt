package com.abdulkhalekomar.library_api.auth

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Size

data class AuthenticationRequest(
	@get:Email val email: String?,
	@get:Size(min = 8, max = 255) val password: String?,
)

data class AuthenticationResponse(
	val token: String?,
)
