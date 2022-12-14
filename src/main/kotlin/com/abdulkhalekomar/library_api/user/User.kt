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
    var id = 0L

    @Column(
        name = "first_name",
        nullable = false,
        length = 100,
    )
    var firstName: String = ""

    @Column(
        name = "last_name",
        nullable = false,
        length = 150,
    )
    var lastName: String = ""

    @Enumerated(EnumType.STRING)
    @Column(
        name = "user_role",
        nullable = false,
        length = 10,
    )
    var userRole: UserRole = UserRole.USER

    @Column(
        name = "email",
        nullable = false,
        length = 150,
    )
    var email: String = ""

    @Column(
        name = "phone",
        length = 15,
    )
    var phone: String? = null

}