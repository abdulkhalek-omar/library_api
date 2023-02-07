package com.abdulkhalekomar.library_api.country

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CountryRequest(
	@get:NotBlank @get:Size(min = 2, max = 150) val countryName: String?,
)

data class CountryResponse(
	val id: Int,
)

fun CountryRequest.toEntity() = Country(
	countryName = countryName
)

fun Country.toResponse() = CountryResponse(
	id = id,
)
