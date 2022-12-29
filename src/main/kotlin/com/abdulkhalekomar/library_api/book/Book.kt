package com.abdulkhalekomar.library_api.book

import com.abdulkhalekomar.library_api.author.Author
import com.abdulkhalekomar.library_api.category.Category
import com.abdulkhalekomar.library_api.langauge.Language
import com.abdulkhalekomar.library_api.publisher.Publisher
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import java.time.LocalDateTime

// import kotlinx.datetime.LocalDateTime
@Entity(name = "Book")
@Table(
    name = "Book",
    uniqueConstraints = [
        UniqueConstraint(
            name = "isbn_unique",
            columnNames = ["isbn"],
        )
    ]
)
data class Book(
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
    var id: Long,

    @Column(
        name = "title",
        nullable = false,
        length = 200,
    )
    var title: String? = null,

    @Column(
        name = "description",
    )
    var description: String? = null,

    @Column(
        name = "number_of_page",
    )
    var numberOfPage: Int? = null,

    @Column(
        name = "isbn",
        length = 20,
    )
    var isbn: String? = null,

    @Column(
        name = "publish_at",
    )
    var publishAt: LocalDateTime? = null,

    @ManyToOne
    @JoinColumn(
        name = "language_id",
        foreignKey = ForeignKey(name = "language_id_fk"),
    )
    var language: Language? = null,

    @ManyToOne
    @JoinColumn(
        name = "author_id",
        foreignKey = ForeignKey(name = "author_id_fk"),
    )
    var author: Author? = null,

    @ManyToOne
    @JoinColumn(
        name = "category_id",
        foreignKey = ForeignKey(name = "category_id_fk"),
    )
    var category: Category? = null,

    @ManyToOne
    @JoinColumn(
        name = "publisher_id",
        foreignKey = ForeignKey(name = "publisher_id_fk")
    )
    var publisher: Publisher? = null,
)