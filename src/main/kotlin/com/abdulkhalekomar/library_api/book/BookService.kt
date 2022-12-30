package com.abdulkhalekomar.library_api.book

import com.abdulkhalekomar.library_api.author.Author
import com.abdulkhalekomar.library_api.category.Category
import com.abdulkhalekomar.library_api.langauge.Language
import com.abdulkhalekomar.library_api.publisher.Publisher
import org.springframework.stereotype.Service

@Service
class BookService(private val iBookRepository: IBookRepository) {
    fun findAllBooks(): List<Book> = iBookRepository.findAll()
    fun findBookById(id: Long) = iBookRepository.findById(id)
    fun createBook(requestBook: Book): String {
        return try {
            val author = Author(id = requestBook.author!!.id)
            val category = Category(id = requestBook.category!!.id)
            val language = Language(id = requestBook.language!!.id)
            val publisher = Publisher(id = requestBook.publisher!!.id)
            requestBook.author = author
            requestBook.category = category
            requestBook.language = language
            requestBook.publisher = publisher
            iBookRepository.save(requestBook)
            "Book is successfully created"
        } catch (e: Exception) {
            "Failed to create book: $e"
        }
    }

    fun updateBook(bookId: Long, requestBook: Book): String {
        val findBook = iBookRepository.findById(bookId)
        if (findBook.isPresent) {
            return try {
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
                iBookRepository.save(book)
                "Book is successfully updated"
            } catch (e: Exception) {
                "Book is found; updated failed: $e"
            }
        }
        return "Failed to update book information"
    }

    fun deleteBook(bookId: Long): String {
        iBookRepository.deleteById(bookId)
        if (!iBookRepository.existsById(bookId)) {
            return "Book is successfully deleted"
        }
        return "Failed to delete Book"
    }
}