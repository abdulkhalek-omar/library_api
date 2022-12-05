package com.abdulkhalekomar.library_api.book

import jakarta.persistence.*
import java.time.LocalDateTime

// import kotlinx.datetime.LocalDateTime


@Entity(name = "Book")
@Table(name = "Book")
class Book {
    @Id
    @SequenceGenerator(
        name = "book_sequence",
        sequenceName = "book_sequence",
        allocationSize = 1,
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "book_sequence",
    )
    private val id = 0L

    @Column(name = "title", nullable = false)
    var title: String = ""

    @Column(name = "description")
    var description: String? = null

    @Column(name = "number_of_page")
    var numberOfPage: Int? = null

    @Column(name = "isbn")
    var isbn: String? = null

    @Column(name = "publish_at")
    var publishAt: LocalDateTime? = null


    /*
    Langauge
    Author
    Publisher
    Category
     */


}