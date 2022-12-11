package com.abdulkhalekomar.library_api.user

import jakarta.persistence.*


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
class User {
    constructor()

    constructor(firstName: String, lastName: String, userRole: UserRole, email: String, phone: String) {
        this.firstName = firstName
        this.lastName = lastName
        this.userRole = userRole
        this.email = email
        this.phone = phone
    }

    @Id
    @SequenceGenerator(
        sequenceName = "user_id_sequence",
        name = "user_id_sequence",
        allocationSize = 1,
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_id_sequence",
    )
    private var id = 0L

    @Column(name = "first_name", nullable = false)
    private var firstName: String = ""

    @Column(name = "last_name", nullable = false)
    private var lastName: String = ""

    @Enumerated(EnumType.STRING)
    private var userRole: UserRole = UserRole.USER

    @Column(name = "email", nullable = false)
    private var email: String = ""

    @Column(name = "phone")
    private var phone: String = ""

}