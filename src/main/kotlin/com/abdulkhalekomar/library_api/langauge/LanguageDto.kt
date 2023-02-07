package com.abdulkhalekomar.library_api.langauge

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class LanguageRequest(
	@get:NotBlank @get:Size(min = 2, max = 2) val iso6391: String?,
)

data class LanguageResponse(
	val id: Int,
)

fun LanguageRequest.toEntity() = Language(
	iso6391 = iso6391,
)

fun Language.toResponse() = LanguageResponse(
	id = id,
)

