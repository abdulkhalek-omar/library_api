package com.abdulkhalekomar.library_api.book

import com.abdulkhalekomar.library_api.author.Author
import com.abdulkhalekomar.library_api.category.Category
import com.abdulkhalekomar.library_api.langauge.Language
import com.abdulkhalekomar.library_api.publisher.Publisher
import jakarta.validation.constraints.Digits
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.PastOrPresent
import jakarta.validation.constraints.Size
import java.time.LocalDateTime

data class BookRequest(
	@get:NotBlank @get:Size(min = 2, max = 200) val title: String?,
	@get:NotNull val description: String?,
	@get:Digits(integer = 4, fraction = 0) val numberOfPage: Int?,
	@get:NotNull @get:Size(max = 20) val isbn: String?,
	@get:PastOrPresent val publishAt: LocalDateTime?,
	val language: Language?,
	val author: Author?,
	val category: Category?,
	val publisher: Publisher?,
)

data class BookResponse(
	val id: Long,
)


fun BookRequest.toEntity() = Book(
	title = title,
	description = description,
	numberOfPage = numberOfPage,
	isbn = isbn,
	publishAt = publishAt,
	language = language,
	author = author,
	category = category,
	publisher = publisher,
)

fun Book.toResponse() = BookResponse(
	id = id
)

