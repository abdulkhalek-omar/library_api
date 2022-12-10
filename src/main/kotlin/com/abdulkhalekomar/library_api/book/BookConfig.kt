package com.abdulkhalekomar.library_api.book

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDateTime

@Configuration
class BookConfig() {

    @Bean
    fun commandLineRunner(bookRepository: BookRepository): CommandLineRunner {
        return CommandLineRunner {
            val book1 = Book(
                title = "",
                description = "",
                numberOfPage = 0,
                isbn = "",
                publishAt = LocalDateTime.now(),
                language = null,
                author = null,
            )
            val book2 = Book(
                title = "",
                description = "",
                numberOfPage = 0,
                isbn = "",
                publishAt = LocalDateTime.of(2022, 12, 7, 0, 0, 0),
                language = null,
                author = null,
            )
            bookRepository.saveAll(listOf(book1, book2))
        }
    }

}