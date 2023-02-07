package com.abdulkhalekomar.library_api.user

import com.abdulkhalekomar.library_api.address.Address
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
	) var firstName: String? = null,

	@Column(
		nullable = false,
		length = 150,
	) var lastName: String? = null,

	// TODO: Create validation annotation for enum
	@Enumerated(EnumType.STRING) @Column(
		nullable = false,
		length = 10,
	) var userRole: UserRole = UserRole.USER,

	@Column(
		nullable = false,
		length = 150,
	) var email: String? = null,

	// TODO: create annotation to validate specifically Phone Number
	@Column(
		length = 15,
	) var phone: String? = null,

	@ManyToOne(fetch = FetchType.LAZY) @JoinColumn(
		name = "address_id", foreignKey = ForeignKey(name = "address_id_fk")
	) var address: Address? = null,

	@Id @SequenceGenerator(
		sequenceName = "user_generator",
		name = "user_seq",
		allocationSize = 1,
	) @GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "user_seq",
	) var id: Long = 0,
)
