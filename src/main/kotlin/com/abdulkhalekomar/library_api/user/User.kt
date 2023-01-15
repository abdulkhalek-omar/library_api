package com.abdulkhalekomar.library_api.user

import com.abdulkhalekomar.library_api.address.Address
import com.abdulkhalekomar.library_api.validation_helpers.annotations.Numeric
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import jakarta.validation.constraints.Digits
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Entity(name = "User")
@Table(
	name = "User",
	uniqueConstraints = [
		UniqueConstraint(
			name = "email_unique", columnNames = ["email"]
		),
		UniqueConstraint(
			name = "phone_unique", columnNames = ["phone"]
		),
	],
)
class User(
	@Column(
		nullable = false,
		length = 100,
	) @get:NotBlank @get:Size(min = 2, max = 100) var firstName: String? = null,

	@Column(
		nullable = false,
		length = 150,
	) @get:NotBlank @get:Size(min = 2, max = 150) var lastName: String? = null,

	@Enumerated(EnumType.STRING) @Column(
		nullable = false,
		length = 10,
	) @get:Max(value = 10) var userRole: UserRole = UserRole.USER,

	@Column(
		nullable = false,
		length = 150,
	) @get:Email var email: String? = null,

	// TODO: create annotation to validate specifically Phone Number
	@Column(
		length = 15,
	) @get:Digits(integer = 15, fraction = 0) var phone: String? = null,

	@ManyToOne(fetch = FetchType.LAZY) @JoinColumn(
		name = "address_id", foreignKey = ForeignKey(name = "address_id_fk")
	) var address: Address? = null,

	@Id @SequenceGenerator(
		sequenceName = "user_generator",
		name = "user_seq",
		allocationSize = 1,
	) @GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "user_generator",
	) var id: Long,
)
