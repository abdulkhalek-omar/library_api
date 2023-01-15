package com.abdulkhalekomar.library_api.author

import com.abdulkhalekomar.library_api.address.Address
import com.abdulkhalekomar.library_api.validation_helpers.annotations.DateFormat
import jakarta.persistence.*
import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Size
import org.jetbrains.annotations.NotNull
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
class Author(
	@get:Column(
		nullable = false,
		length = 100,
	) @get:NotNull @get:Size(min = 2, max = 100) var firstName: String? = null,


	@get:Column(
		nullable = false,
		length = 150,
	) @get:NotNull @get:Size(min = 2, max = 150) var lastName: String? = null,

	var cv: String? = null,

	@Temporal(TemporalType.DATE) @get:Past var birthDate: LocalDate? = null,

	@ManyToOne @JoinColumn(
		name = "address_id", foreignKey = ForeignKey(name = "address_id_author_fk")
	) var address: Address? = null,

	@Id @SequenceGenerator(
		name = "author_generator", sequenceName = "author_seq", allocationSize = 1,
	) @GeneratedValue(
		strategy = GenerationType.SEQUENCE, generator = "author_seq",
	) var id: Long,
)
