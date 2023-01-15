package com.abdulkhalekomar.library_api.publisher

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import kotlin.math.max

@Entity
class Publisher(
	@Column(
		nullable = false,
	) @get:NotBlank @get:Size(max = 255) var publisherName: String? = null,

	@Id @SequenceGenerator(
		sequenceName = "publisher_id_sequence",
		name = "publisher_id_sequence",
		allocationSize = 1,
	) @GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "publisher_id_sequence",
	) var id: Long,
)
