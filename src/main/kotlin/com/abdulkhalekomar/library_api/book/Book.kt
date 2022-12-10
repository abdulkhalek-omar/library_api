package com.abdulkhalekomar.library_api.book

import com.abdulkhalekomar.library_api.author.Author
import com.abdulkhalekomar.library_api.category.Category
import com.abdulkhalekomar.library_api.langauge.Language
import com.abdulkhalekomar.library_api.publisher.Publisher
import jakarta.persistence.*
import java.time.LocalDateTime

// import kotlinx.datetime.LocalDateTime


@Entity(name = "Book")
@Table(name = "Book")
class Book {
    constructor()
    constructor(
        title: String,
        description: String?,
        numberOfPage: Int?,
        isbn: String?,
        publishAt: LocalDateTime?,
        language: Language,
        author: Author,
        category: Category,
        publisher: Publisher,
    ) {
        this.title = title
        this.description = description
        this.numberOfPage = numberOfPage
        this.isbn = isbn
        this.publishAt = publishAt
        this.language = language
        this.author = author
        this.category = category
        this.publisher = publisher
    }

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
    private var id = 0L

    @Column(name = "title", nullable = false)
    private var title: String = ""

    @Column(name = "description")
    private var description: String? = null

    @Column(name = "number_of_page")
    private var numberOfPage: Int? = null

    @Column(name = "isbn")
    private var isbn: String? = null

    @Column(name = "publish_at")
    private var publishAt: LocalDateTime? = null

    @ManyToOne
    @JoinColumn(
        name = "language_id",
        foreignKey = ForeignKey(name = "language_id_fk"),
    )
    private var language: Language = Language()

    @ManyToOne
    @JoinColumn(
        name = "author_id",
        foreignKey = ForeignKey(name = "author_id_fk"),
    )
    private var author: Author = Author()

    @ManyToOne
    @JoinColumn(
        name = "category_id",
        foreignKey = ForeignKey(name = "category_id_fk"),
    )
    private var category: Category = Category()

    @ManyToOne
    @JoinColumn(
        name = "publisher_id",
        foreignKey = ForeignKey(name = "publisher_id_fk")
    )
    private var publisher: Publisher = Publisher()

}