package com.abdulkhalekomar.library_api.book

import com.abdulkhalekomar.library_api.langauge.Language
import jakarta.persistence.*
import java.time.LocalDateTime

// import kotlinx.datetime.LocalDateTime


@Entity(name = "Book")
@Table(name = "Book")
class Book {
    @Id
    @SequenceGenerator(
        name = "book_id_sequence",
        sequenceName = "book_id_sequence",
        allocationSize = 1,
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "book_id_sequence",
    )
    private val id = 0L

    @Column(name = "title", nullable = false)
    private val title: String = ""

    @Column(name = "description")
    private val description: String? = null

    @Column(name = "number_of_page")
    private val numberOfPage: Int? = null

    @Column(name = "isbn")
    private val isbn: String? = null

    @Column(name = "publish_at")
    private val publishAt: LocalDateTime? = null


    /*
    Langauge
    Author
    Publisher
    Category
     */


}