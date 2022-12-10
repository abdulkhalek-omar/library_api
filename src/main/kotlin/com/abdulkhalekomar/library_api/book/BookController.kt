package com.abdulkhalekomar.library_api.book

import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(private val bookService: BookService) {

}