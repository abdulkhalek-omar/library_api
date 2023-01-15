package com.abdulkhalekomar.library_api.publisher

import org.springframework.stereotype.Service

@Service
class PublisherService(private val publisherRepository: IPublisherRepository) {
	fun findAllPublisher(): Iterable<Publisher> = publisherRepository.findAll()
	fun findPublisherById(publisherId: Long) = publisherRepository.findById(publisherId)

	fun createPublisher(requestPublisher: Publisher): String {
		return try {
			publisherRepository.save(requestPublisher)
			"Publisher is successfully created"
		} catch (e: Exception) {
			"Failed to create Publisher: $e"
		}
	}

	fun updatePublisher(publisherId: Long, requestPublisher: Publisher): String {
		val findPublisher = publisherRepository.findById(publisherId)
		if (findPublisher.isPresent) {
			val publisher = findPublisher.get()
			publisher.publisherName = requestPublisher.publisherName
			publisherRepository.save(publisher)
			return "Publisher is successfully Updated"
		}
		return "Failed to Updated Publisher"
	}

	fun deletePublisher(publisherId: Long): String {
		publisherRepository.deleteById(publisherId)
		if (!publisherRepository.existsById(publisherId)) {
			return "Publisher is deleted successfully"
		}
		return "Failed to deleted Publisher"
	}
}
