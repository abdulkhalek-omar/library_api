package com.abdulkhalekomar.library_api.publisher

import org.springframework.stereotype.Service

@Service
class PublisherService(private val iPublisherRepository: IPublisherRepository) {
    fun findAllPublisher(): Iterable<Publisher> = iPublisherRepository.findAll()
    fun findPublisherById(publisherId: Long) = iPublisherRepository.findById(publisherId)

    fun createPublisher(requestPublisher: Publisher): String {
        return try {
            iPublisherRepository.save(requestPublisher)
            "Publisher is successfully created"
        } catch (e: Exception) {
            "Failed to create Publisher: $e"
        }
    }

    fun updatePublisher(publisherId: Long, requestPublisher: Publisher): String {
        val findPublisher = iPublisherRepository.findById(publisherId)
        if (findPublisher.isPresent) {
            val publisher = findPublisher.get()
            publisher.publisherName = requestPublisher.publisherName
            iPublisherRepository.save(publisher)
            return "Publisher is successfully created"
        }
        return "Failed to created Publisher"
    }

    fun deletePublisher(publisherId: Long): String {
        iPublisherRepository.deleteById(publisherId)
        if (!iPublisherRepository.existsById(publisherId)) {
            return "Publisher is deleted successfully"
        }
        return "Failed to deleted Publisher"
    }
}