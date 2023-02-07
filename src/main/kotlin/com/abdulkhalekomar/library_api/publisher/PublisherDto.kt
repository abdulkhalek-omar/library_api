package com.abdulkhalekomar.library_api.publisher

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class PublisherRequest(
	@get:NotBlank @get:Size(max = 255) val publisherName: String?,
)

data class PublisherResponse(
	val id: Long,
)

fun PublisherRequest.toEntity() = Publisher(
	publisherName = publisherName,
)

fun Publisher.toResponse() = PublisherResponse(
	id = id,
)
