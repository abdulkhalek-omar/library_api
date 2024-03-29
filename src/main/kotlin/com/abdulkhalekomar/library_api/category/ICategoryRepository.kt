package com.abdulkhalekomar.library_api.category

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ICategoryRepository : CrudRepository<Category, Long>