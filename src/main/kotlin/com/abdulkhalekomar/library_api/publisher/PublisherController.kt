package com.abdulkhalekomar.library_api.publisher

import org.springframework.web.bind.annotation.RestController

@RestController
class PublisherController(private val publisherService: PublisherService) {
}