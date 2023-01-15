package com.abdulkhalekomar.library_api.country

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

// Todo: ISO 3166-1 alpha-2
@Entity
@Table(
	uniqueConstraints = [
		UniqueConstraint(
			name = "country_name_unique",
			columnNames = ["country_name"],
		),
	],
)
class Country(

	@Column(
		name = "country_name",
		nullable = false,
		length = 150,
	) @get:NotBlank @get:Size(min = 2, max = 150) var countryName: String? = null,

	@Id @SequenceGenerator(
		sequenceName = "country_generator",
		name = "country_seq",
		allocationSize = 1,
	) @GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "country_generator",
	) var id: Int,
)
