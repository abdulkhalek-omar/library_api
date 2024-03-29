package com.abdulkhalekomar.library_api.langauge

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint

@Entity
@Table(
	uniqueConstraints = [
		UniqueConstraint(
			name = "iso_639_1_unique",
			columnNames = ["iso_639_1"]
		)
	]
)
class Language(
	@Column(name = "iso_639_1", nullable = false, length = 2)
	var iso6391: String? = null,

	@Id @SequenceGenerator(name = "language_seq_gen", sequenceName = "language_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "language_seq")
	var id: Int = 0,
)
