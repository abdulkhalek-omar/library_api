package com.abdulkhalekomar.library_api.author

import com.abdulkhalekomar.library_api.address.Address
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class AuthorService(private val authorRepository: IAuthorRepository) {
	fun findAllAuthors(): Iterable<Author> = authorRepository.findAll()

	fun findAuthorById(authorId: Long) = authorRepository.findById(authorId)

	fun createAuthor(authorRequest: AuthorRequest): ResponseEntity<AuthorCreateResponse> {
		val author = authorRequest.toEntity()
		val address = Address(id = author.address!!.id)
		author.address = address
		return ResponseEntity.ok(authorRepository.save(author).toCreateResponse())
	}

	fun updateAuthor(authorId: Long, authorRequest: AuthorRequest): ResponseEntity<AuthorUpdateResponse> {
		val findAuthor = authorRepository.findById(authorId)
		if (!findAuthor.isPresent) {
			return ResponseEntity.notFound().build()
		}
		val author = findAuthor.get()
		author.birthDate = authorRequest.birthDate
		author.cv = authorRequest.cv
		author.firstName = authorRequest.firstName
		author.lastName = authorRequest.lastName
		author.address = authorRequest.address
		authorRepository.save(author)
		return ResponseEntity.ok(author.toUpdateResponse())
	}

	fun deleteAuthor(authorId: Long): String {
		authorRepository.deleteById(authorId)
		if (!authorRepository.existsById(authorId)) {
			return "Author is successfully deleted"
		}
		return "Failed to delete Author"
	}
}
