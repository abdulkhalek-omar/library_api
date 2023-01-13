package com.abdulkhalekomar.library_api.address

import com.abdulkhalekomar.library_api.country.Country
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.SequenceGenerator
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Entity
class Address(
	@Column(
		length = 150,
		nullable = false,
	) @get:NotBlank @get:Size(max = 150) var street: String? = null,

	@Column(
		nullable = false,
	) @NotBlank @Size(max = 255) var addressLine1: String? = null,

	@Column(
	) @Max(value = 255) var addressLine2: String? = null,

	@Column(
		length = 150,
		nullable = false,
	) @NotBlank @Max(value = 150) var city: String = "",

	@Column(
		length = 10,
		nullable = false,
	) @NotBlank @Max(value = 10) var postalCode: String = "",

	@ManyToOne @JoinColumn(
		name = "country_id", foreignKey = ForeignKey(name = "country_id_fk")
	) var country: Country? = null,

	@Id @SequenceGenerator(
		sequenceName = "address_generator",
		name = "address_seq",
		allocationSize = 1,
	) @GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "address_seq",
	) var id: Long,
)
