package com.abdulkhalekomar.library_api.country

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint

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

	@Column(name = "country_name", nullable = false, length = 2)
	var countryName: String? = null,

	@Id @SequenceGenerator(name = "country_seq_gen", sequenceName = "country_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_seq")
	var id: Int = 0,
)
