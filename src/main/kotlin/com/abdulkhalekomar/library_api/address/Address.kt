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

@Entity
class Address(
	@Column(length = 150, nullable = false) var street: String = "",

	@Column(nullable = false) var addressLine1: String = "",

	var addressLine2: String? = null,

	@Column(length = 150, nullable = false) var city: String = "",

	@Column(length = 10, nullable = false) var postalCode: String = "",

	@ManyToOne @JoinColumn(
		name = "country_id", foreignKey = ForeignKey(name = "country_id_fk"),
	) var country: Country? = null,

	@Id @SequenceGenerator(
		sequenceName = "address_generator", name = "address_seq", allocationSize = 1,
	) @GeneratedValue(
		strategy = GenerationType.SEQUENCE, generator = "address_seq",
	) var id: Long = 0,
)
