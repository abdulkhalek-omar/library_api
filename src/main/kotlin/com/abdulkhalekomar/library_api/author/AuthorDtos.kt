package com.abdulkhalekomar.library_api.author

import com.abdulkhalekomar.library_api.address.Address
import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Size
import org.jetbrains.annotations.NotNull
import java.time.LocalDate

data class AuthorRequest(
	@get:NotNull @get:Size(min = 2, max = 100) val firstName: String?,
	@get:NotNull @get:Size(min = 2, max = 150) val lastName: String?,
	val cv: String?,
	@get:Past val birthDate: LocalDate?,
	val address: Address?,
)

data class AuthorCreateResponse(
	val id: Long?,
)

data class AuthorUpdateResponse(
	val firstName: String?,
	val lastName: String?,
	val cv: String?,
	val birthDate: LocalDate?,
	val address: Address?,
)

fun AuthorRequest.toEntity() = Author(
	firstName = firstName,
	lastName = lastName,
	cv = cv,
	birthDate = birthDate,
	address = address,
)

fun Author.toCreateResponse() = AuthorCreateResponse(
	id = id,
)

fun Author.toUpdateResponse() = AuthorUpdateResponse(
	firstName = firstName,
	lastName = lastName,
	cv = cv,
	birthDate = birthDate,
	address = address,
)
