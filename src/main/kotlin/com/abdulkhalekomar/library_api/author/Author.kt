package com.abdulkhalekomar.library_api.author

import com.abdulkhalekomar.library_api.address.Address
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import java.time.LocalDate

@Entity
class Author(
	@Column(nullable = false, length = 100) var firstName: String? = null,


	@Column(nullable = false, length = 150) var lastName: String? = null,

	var cv: String? = null,

	@Temporal(TemporalType.DATE) var birthDate: LocalDate? = null,

	@ManyToOne @JoinColumn(
		name = "address_id", foreignKey = ForeignKey(name = "address_id_author_fk")
	) var address: Address? = null,

	@Id @SequenceGenerator(
		name = "author_generator", sequenceName = "author_seq", allocationSize = 1,
	) @GeneratedValue(
		strategy = GenerationType.SEQUENCE, generator = "author_seq",
	) var id: Long = 0,
)
