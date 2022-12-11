package com.abdulkhalekomar.library_api.book

import com.abdulkhalekomar.library_api.author.Author
import com.abdulkhalekomar.library_api.category.Category
import com.abdulkhalekomar.library_api.langauge.Language
import com.abdulkhalekomar.library_api.publisher.Publisher
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDateTime

@Configuration
class BookConfig() {
//
//    @Bean
//    fun commandLineRunner(bookRepository: BookRepository): CommandLineRunner {
//        return CommandLineRunner {
//            val book1 = Book(
//                title = "",
//                description = "",
//                numberOfPage = 0,
//                isbn = "",
//                publishAt = LocalDateTime.now(),
//                language = Language(),
//                author = Author(),
//                category = Category(),
//                publisher = Publisher(),
//            )
//            val book2 = Book(
//                title = "",
//                description = "",
//                numberOfPage = 0,
//                isbn = "",
//                publishAt = LocalDateTime.of(2022, 12, 7, 0, 0, 0),
//                language = Language(),
//                author = Author(),
//                category = Category(),
//                publisher = Publisher(),
//            )
//            bookRepository.saveAll(listOf(book1, book2))
//        }
//    }

}