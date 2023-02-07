package com.abdulkhalekomar.library_api.category

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CategoryRequest(
	@get:NotBlank @get:Size(min = 2, max = 150) val categoryName: String?,
)

data class CategoryResponse(
	val id: Long,
)

fun CategoryRequest.toEntity() = Category(
	categoryName = categoryName,
)

fun Category.toResponse() = CategoryResponse(
	id = id,
)
