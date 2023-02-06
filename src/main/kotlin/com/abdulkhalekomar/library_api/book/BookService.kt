package com.abdulkhalekomar.library_api.book

import com.abdulkhalekomar.library_api.author.Author
import com.abdulkhalekomar.library_api.category.Category
import com.abdulkhalekomar.library_api.langauge.Language
import com.abdulkhalekomar.library_api.publisher.Publisher
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: IBookRepository) {
	fun findAllBooks(): Iterable<Book> = bookRepository.findAll()
	fun findBookById(id: Long) = bookRepository.findById(id)
	fun createBook(requestBook: BookRequest): ResponseEntity<BookResponse> {
		val book = requestBook.toEntity()
		val author = Author(id = book.author!!.id)
		val category = Category(id = book.category!!.id)
		val language = Language(id = book.language!!.id)
		val publisher = Publisher(id = book.publisher!!.id)
		book.author = author
		book.category = category
		book.language = language
		book.publisher = publisher
		return ResponseEntity.ok(bookRepository.save(book).toResponse())
	}

	fun updateBook(bookId: Long, requestBook: BookRequest): ResponseEntity<BookResponse> {
		val findBook = bookRepository.findById(bookId)
		if (!findBook.isPresent) {
			return ResponseEntity.notFound().build()
		}
		val book = findBook.get()
		book.description = requestBook.description
		book.isbn = requestBook.isbn
		book.numberOfPage = requestBook.numberOfPage
		book.publishAt = requestBook.publishAt
		book.title = requestBook.title
		book.author = requestBook.author
		book.category = requestBook.category
		book.language = requestBook.language
		book.publisher = requestBook.publisher
		return ResponseEntity.ok(bookRepository.save(book).toResponse())
	}

	fun deleteBook(bookId: Long): String {
		bookRepository.deleteById(bookId)
		if (!bookRepository.existsById(bookId)) {
			return "Book is successfully deleted"
		}
		return "Failed to delete Book"
	}
}
