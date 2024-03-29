package com.abdulkhalekomar.library_api.book

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/book")
class BookController(private val bookService: BookService) {
	@GetMapping("/all")
	fun findAllBooks() = bookService.findAllBooks()

	@GetMapping("/{bookId}")
	fun findBookById(@PathVariable bookId: Long) = bookService.findBookById(bookId)

	@PostMapping
	fun createBook(@Valid @RequestBody requestBook: BookRequest) = bookService.createBook(requestBook)

	@PutMapping("/{bookId}")
	fun updateBook(@PathVariable bookId: Long, @Valid @RequestBody requestBook: BookRequest) =
		bookService.updateBook(bookId, requestBook)

	@DeleteMapping("/{bookId}")
	fun deleteBook(@PathVariable bookId: Long) = bookService.deleteBook(bookId)
}
