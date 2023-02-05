package com.abdulkhalekomar.library_api.address

import com.abdulkhalekomar.library_api.country.Country
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class AddressRequest(
	@get:NotBlank @get:Size(max = 150) val street: String?,
	@get:NotBlank @get:Size(max = 255) val addressLine1: String?,
	val addressLine2: String?,
	@get:NotBlank @get:Size(max = 150) val city: String?,
	@get:NotBlank @get:Size(max = 10) val postalCode: String?,
	val country: Country?,
)

data class AddressCreateResponse(
	val id: Long,
)

data class AddressUpdateResponse(
	val street: String?,
	val addressLine1: String?,
	val addressLine2: String?,
	val city: String?,
	val postalCode: String?,
	val country: Country?,
)

fun AddressRequest.toEntity() = Address(
	street = street,
	addressLine1 = addressLine1,
	addressLine2 = addressLine2,
	city = city,
	postalCode = postalCode,
	country = country,
)

fun Address.toCreateResponse() = AddressCreateResponse(
	id = id,
)

fun Address.toUpdateResponse() = AddressUpdateResponse(
	street = street,
	addressLine1 = addressLine1,
	addressLine2 = addressLine2,
	city = city,
	postalCode = postalCode,
	country = country,
)
