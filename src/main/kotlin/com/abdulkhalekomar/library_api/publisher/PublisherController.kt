package com.abdulkhalekomar.library_api.publisher

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
@RequestMapping("/api/v1/publisher")
class PublisherController(private val publisherService: PublisherService) {
	@GetMapping("/all")
	fun findAllPublisher() = publisherService.findAllPublisher()

	@GetMapping("/{publisherId}")
	fun findPublisherById(@PathVariable publisherId: Long) = publisherService.findPublisherById(publisherId)

	@PostMapping
	fun createPublisher(@Valid @RequestBody requestPublisher: PublisherRequest) = publisherService.createPublisher(requestPublisher)

	@PutMapping("/{publisherId}")
	fun updatePublisher(@PathVariable publisherId: Long, @Valid @RequestBody requestPublisher: PublisherRequest) = publisherService.updatePublisher(publisherId, requestPublisher)

	@DeleteMapping("/{publisherId}")
	fun deletePublisher(@PathVariable publisherId: Long) = publisherService.deletePublisher(publisherId)
}
