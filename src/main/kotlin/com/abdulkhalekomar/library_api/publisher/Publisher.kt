package com.abdulkhalekomar.library_api.publisher

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator

@Entity
class Publisher(
	@Column(nullable = false)
	var publisherName: String? = null,

	@Id @SequenceGenerator(name = "publisher_seq_gen", sequenceName = "publisher_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_seq")
	var id: Long = 0,
)
