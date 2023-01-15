package com.abdulkhalekomar.library_api.category

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

@Entity
@Table(
	uniqueConstraints = [
		UniqueConstraint(
			name = "category_name_unique",
			columnNames = ["category_name"],
		),
	],
)
class Category(
	@Column(
		name = "category_name",
		nullable = false,
		unique = true,
		length = 150,
	) @get:NotBlank @get:Size(min = 2, max = 150) var categoryName: String = "",

	@Id @SequenceGenerator(
		name = "category_generator",
		sequenceName = "category_seq",
		allocationSize = 1,
	) @GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "category_seq",
	) var id: Long,

	)
