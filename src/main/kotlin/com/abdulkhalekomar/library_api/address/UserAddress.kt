package com.abdulkhalekomar.library_api.address

import com.abdulkhalekomar.library_api.address.address.Address
import com.abdulkhalekomar.library_api.user.User
import jakarta.persistence.Entity
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
import org.hibernate.annotations.NaturalId

@Entity(name = "User_Address")
@Table(
    name = "User_Address",
    uniqueConstraints = [
        UniqueConstraint(
            name = "user_id_address_id_unique",
            columnNames = ["user_id", "address_id"]
        )
    ]
)
data class UserAddress (
    @Id
    @NaturalId
    @SequenceGenerator(
        sequenceName = "user_address_generator",
        name = "user_address_seq",
        allocationSize = 1,
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_address_seq",
    )
    var id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "address_id",
        foreignKey = ForeignKey(name = "address_id_user_fk")
    )
    var address: Address,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "user_id",
        foreignKey = ForeignKey(name = "user_id_address_fk")
    )
    var user: User,
)