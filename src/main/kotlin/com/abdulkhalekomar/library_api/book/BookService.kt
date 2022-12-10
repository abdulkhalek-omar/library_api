package com.abdulkhalekomar.library_api.book

import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository) {
}