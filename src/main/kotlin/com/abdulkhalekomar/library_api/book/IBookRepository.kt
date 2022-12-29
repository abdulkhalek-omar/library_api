package com.abdulkhalekomar.library_api.book

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IBookRepository : JpaRepository<Book, Long>