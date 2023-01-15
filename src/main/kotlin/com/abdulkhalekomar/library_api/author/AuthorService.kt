package com.abdulkhalekomar.library_api.author

import com.abdulkhalekomar.library_api.address.Address
import org.springframework.stereotype.Service

@Service
class AuthorService(private val authorRepository: IAuthorRepository) {
	fun findAllAuthors(): Iterable<Author> = authorRepository.findAll()

	fun findAuthorById(authorId: Long) = authorRepository.findById(authorId)

	fun createAuthor(authorRequest: Author): String {
		return try {
			val address = Address(id = authorRequest.address!!.id)
			authorRequest.address = address
			authorRepository.save(authorRequest)
			"Author created successfully"
		} catch (e: Exception) {
			"Failed to create Author: $e"
		}
	}

	fun updateAuthor(authorId: Long, authorRequest: Author): String {
		val findAuthor = authorRepository.findById(authorId)
		if (findAuthor.isPresent) {
			val author = findAuthor.get()
			author.birthDate = authorRequest.birthDate
			author.cv = authorRequest.cv
			author.firstName = authorRequest.firstName
			author.lastName = authorRequest.lastName
			author.address = authorRequest.address
			authorRepository.save(author)
			return "Author is successfully updated"
		}
		return "Failed to updated Author"
	}

	fun deleteAuthor(authorId: Long): String {
		authorRepository.deleteById(authorId)
		if (!authorRepository.existsById(authorId)) {
			return "Author is successfully deleted"
		}
		return "Failed to delete Author"
	}
}
