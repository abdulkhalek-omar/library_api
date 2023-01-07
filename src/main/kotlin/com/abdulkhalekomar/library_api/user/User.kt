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
data class User(
    @Id @SequenceGenerator(
        sequenceName = "user_generator",
        name = "user_seq",
        allocationSize = 1,
    ) @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_generator",
    ) var id: Long,

    @Column(
        nullable = false,
        length = 100,
    ) @NotBlank @Size(min = 2, max = 100) var firstName: String = "",

    @Column(
        nullable = false,
        length = 150,
    ) @NotBlank @Size(min = 2, max = 150) var lastName: String = "",

    @Enumerated(EnumType.STRING) @Column(
        nullable = false,
        length = 10,
    ) @Max(value = 10) var userRole: UserRole = UserRole.USER,

    @Column(
        nullable = false,
        length = 150,
    ) @Email var email: String = "",

    // TODO: create annotation to validate specifically Phone Number not just Number-Format
    @Column(
        length = 15,
    ) @Numeric var phone: String = "",

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(
        name = "address_id", foreignKey = ForeignKey(name = "address_id_fk")
    ) var address: Address? = null,
)