package com.abdulkhalekomar.library_api.user

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import jakarta.persistence.Version
import org.hibernate.annotations.DynamicUpdate
import org.hibernate.annotations.NaturalId
import org.hibernate.annotations.OptimisticLockType
import org.hibernate.annotations.OptimisticLocking
import org.hibernate.annotations.SelectBeforeUpdate


@DynamicUpdate
@OptimisticLocking(type = OptimisticLockType.VERSION)
@SelectBeforeUpdate
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
    @Id
    @NaturalId
    @SequenceGenerator(
        sequenceName = "user_generator",
        name = "user_seq",
        allocationSize = 1,
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_generator",
    )
    var id: Long,

    @Column(
        nullable = false,
        length = 100,
    )
    var firstName: String,

    @Column(
        nullable = false,
        length = 150,
    )
    var lastName: String,

    @Enumerated(EnumType.STRING)
    @Column(
        nullable = false,
        length = 10,
    )
    var userRole: UserRole = UserRole.USER,

    @Column(
        nullable = false,
        length = 150,
    )
    var email: String,

    @Column(
        length = 15,
    )
    var phone: String,

    @Version
    var version: Int,
)