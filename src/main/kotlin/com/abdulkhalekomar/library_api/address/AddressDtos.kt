package com.abdulkhalekomar.library_api.address

import com.abdulkhalekomar.library_api.country.Country
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class AddressCreateRequest(
	@get:NotBlank @get:Size(max = 150) val street: String,
	@get:NotBlank @get:Size(max = 255) val addressLine1: String,
	val addressLine2: String? = null,
	@get:NotBlank @get:Size(max = 150) val city: String,
	@get:NotBlank @get:Size(max = 10) val postalCode: String,
	val country: Country? = null,
)

data class AddressUpdateRequest(
	val street: String,
)

data class AddressResponse(
	val id: Long,
	val street: String,
)


fun AddressCreateRequest.toEntity() = Address(
	street = street,
	addressLine1 = addressLine1,
	addressLine2 = addressLine2,
	city = city,
	postalCode = postalCode,
	country = country,
)

fun AddressUpdateRequest.toEntity(id: Long) = Address(
	id = id,
	street = street,
)

fun Address.toResponse() = AddressResponse(
	id = id,
	street = street,
)
