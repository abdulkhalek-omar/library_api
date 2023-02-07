package com.abdulkhalekomar.library_api.publisher

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class PublisherService(private val publisherRepository: IPublisherRepository) {
	fun findAllPublisher(): Iterable<Publisher> = publisherRepository.findAll()
	fun findPublisherById(publisherId: Long) = publisherRepository.findById(publisherId)

	fun createPublisher(requestPublisher: PublisherRequest): ResponseEntity<PublisherResponse> {
		return ResponseEntity.ok(publisherRepository.save(requestPublisher.toEntity()).toResponse())
	}

	fun updatePublisher(publisherId: Long, requestPublisher: PublisherRequest): ResponseEntity<PublisherResponse> {
		val findPublisher = publisherRepository.findById(publisherId)
		if (!findPublisher.isPresent) {
			return ResponseEntity.notFound().build()
		}
		val publisher = findPublisher.get()
		publisher.publisherName = requestPublisher.publisherName
		return ResponseEntity.ok(publisherRepository.save(publisher).toResponse())
	}

	fun deletePublisher(publisherId: Long): String {
		publisherRepository.deleteById(publisherId)
		if (!publisherRepository.existsById(publisherId)) {
			return "Publisher is deleted successfully"
		}
		return "Failed to deleted Publisher"
	}
}
