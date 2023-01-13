package com.abdulkhalekomar.library_api.author

import com.abdulkhalekomar.library_api.address.Address
import org.springframework.stereotype.Service

@Service
class AuthorService(private val iAuthorRepository: IAuthorRepository) {
    fun findAllAuthors(): Iterable<Author> = iAuthorRepository.findAll()

    fun findAuthorById(authorId: Long) = iAuthorRepository.findById(authorId)

    fun createAuthor(authorRequest: Author): String {
        return try {
            val address = Address(id = authorRequest.address!!.id)
            authorRequest.address = address
            iAuthorRepository.save(authorRequest)
            "Author created successfully"
        } catch (e: Exception) {
            "Failed to create Author"
        }
    }

    fun updateAuthor(authorId: Long, authorRequest: Author): String {
        val findAuthor = iAuthorRepository.findById(authorId)
        if (findAuthor.isPresent) {
            val author = findAuthor.get()
            author.birthDate = authorRequest.birthDate
            author.cv = authorRequest.cv
            author.firstName = authorRequest.firstName
            author.lastName = authorRequest.lastName
            author.address = authorRequest.address
            iAuthorRepository.save(author)
            return "Author is successfully updated"
        }
        return "Failed to updated Author"
    }

    fun deleteAuthor(authorId: Long): String {
        iAuthorRepository.deleteById(authorId)
        if (!iAuthorRepository.existsById(authorId)) {
            return "Author is successfully deleted"
        }
        return "Failed to delete Author"
    }
}
