package com.abdulkhalekomar.library_api.publisher

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PublisherRepository : CrudRepository<Publisher, Long>