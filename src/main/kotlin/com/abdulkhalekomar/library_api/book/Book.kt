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
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import jakarta.persistence.UniqueConstraint
import jakarta.validation.constraints.Digits
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.PastOrPresent
import jakarta.validation.constraints.Size
import java.time.LocalDateTime
import kotlin.math.max

// import kotlinx.datetime.LocalDateTime
@Entity
@Table(
	uniqueConstraints = [UniqueConstraint(
		name = "isbn_unique",
		columnNames = ["isbn"],
	)]
)
class Book(
	@Column(
		nullable = false,
		length = 200,
	) @get:NotBlank @get:Size(min = 2, max = 200) var title: String? = null,

	@get:NotNull var description: String? = null,

	@get:Digits(integer = 4, fraction = 0) var numberOfPage: Int? = null,

	@Column(length = 20) @get:NotNull @get:Size(max = 20) var isbn: String? = null,

	@Temporal(TemporalType.TIMESTAMP) @get:PastOrPresent var publishAt: LocalDateTime? = null,

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

	@Id @SequenceGenerator(
		name = "book_generator",
		sequenceName = "book_seq",
		allocationSize = 1,
	) @GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "book_seq",
	) var id: Long,
)
