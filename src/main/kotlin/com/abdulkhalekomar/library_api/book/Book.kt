package com.abdulkhalekomar.library_api.book

import com.abdulkhalekomar.library_api.author.Author
import com.abdulkhalekomar.library_api.category.Category
import com.abdulkhalekomar.library_api.langauge.Language
import com.abdulkhalekomar.library_api.publisher.Publisher
import com.abdulkhalekomar.library_api.validation_helpers.annotations.DateFormat
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
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDateTime

// import kotlinx.datetime.LocalDateTime
@Entity(name = "Book")
@Table(
    name = "Book", uniqueConstraints = [UniqueConstraint(
        name = "isbn_unique",
        columnNames = ["isbn"],
    )]
)
data class Book(
    @Id @SequenceGenerator(
        name = "book_id_sequence",
        sequenceName = "book_id_sequence",
        allocationSize = 1,
    ) @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "book_id_sequence",
    ) var id: Long,

    @Column(
        name = "title",
        nullable = false,
        length = 200,
    ) @NotBlank @Size(min = 2, max = 200) var title: String = "",

    @Column(
        name = "description",
    ) @NotNull var description: String = "",

    @Column(
        name = "number_of_page",
    ) var numberOfPage: Int? = null,

    @Column(
        name = "isbn",
        length = 20,
    ) @NotNull @Max(value = 20) var isbn: String = "",

    @Column(
        name = "publish_at",
    ) @DateFormat var publishAt: LocalDateTime? = null,

    @ManyToOne @JoinColumn(
        name = "language_id",
        foreignKey = ForeignKey(name = "language_id_fk"),
    ) var language: Language? = null,

    @ManyToOne @JoinColumn(
        name = "author_id",
        foreignKey = ForeignKey(name = "author_id_fk"),
    ) var author: Author? = null,

    @ManyToOne @JoinColumn(
        name = "category_id",
        foreignKey = ForeignKey(name = "category_id_fk"),
    ) var category: Category? = null,

    @ManyToOne @JoinColumn(
        name = "publisher_id", foreignKey = ForeignKey(name = "publisher_id_fk")
    ) var publisher: Publisher? = null,
)