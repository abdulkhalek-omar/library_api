package com.abdulkhalekomar.library_api.author

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
@RequestMapping("/api/v1/author")
class AuthorController(private val authorService: AuthorService) {
	@GetMapping("/all")
	fun findAllAuthors() = authorService.findAllAuthors()

	@GetMapping("/{authorId}")
	fun findAuthorById(@PathVariable authorId: Long) = authorService.findAuthorById(authorId)

	@PostMapping
	fun createAuthor(@Valid @RequestBody authorRequest: Author) = authorService.createAuthor(authorRequest)

	@PutMapping("/{authorId}")
	fun updateAuthor(@PathVariable authorId: Long, @Valid @RequestBody authorRequest: Author) =
		authorService.updateAuthor(authorId, authorRequest)

	@DeleteMapping("/{authorId}")
	fun deleteAuthor(@PathVariable authorId: Long) = authorService.deleteAuthor(authorId)
}
