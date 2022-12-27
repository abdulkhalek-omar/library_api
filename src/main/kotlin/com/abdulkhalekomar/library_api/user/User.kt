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
import jakarta.persistence.Version
import org.hibernate.annotations.DynamicUpdate
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
    var firstName: String? = null,

    @Column(
        nullable = false,
        length = 150,
    )
    var lastName: String? = null,

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
    var email: String? = null,

    @Column(
        length = 15,
    )
    var phone: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "address_id",
        foreignKey = ForeignKey(name = "address_id_fk")
    )
    var address: Address? = null,

    @Version
    var version: Int,
)