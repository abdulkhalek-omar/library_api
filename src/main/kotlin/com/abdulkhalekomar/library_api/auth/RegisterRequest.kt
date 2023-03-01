package com.abdulkhalekomar.library_api.auth


data class RegisterRequest(
	val firstName: String?,
	val lastName: String?,
	val email: String?,
	val password: String?,
)
