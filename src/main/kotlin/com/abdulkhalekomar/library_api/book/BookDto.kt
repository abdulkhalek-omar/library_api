package com.abdulkhalekomar.library_api.book

import java.io.Serializable
import java.time.LocalDateTime

data class BookDto(
    val title: String? = null,
    val description: String? = null,
    val numberOfPage: Int? = null,
    val isbn: String? = null,
    val publishAt: LocalDateTime? = null,
) : Serializable