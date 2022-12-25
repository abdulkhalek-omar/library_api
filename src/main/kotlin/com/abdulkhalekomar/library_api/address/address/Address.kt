package com.abdulkhalekomar.library_api.address.address

import com.abdulkhalekomar.library_api.address.country.Country
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import jakarta.persistence.Version
import org.hibernate.annotations.DynamicUpdate
import org.hibernate.annotations.NaturalId
import org.hibernate.annotations.OptimisticLockType
import org.hibernate.annotations.OptimisticLocking
import org.hibernate.annotations.SelectBeforeUpdate


@DynamicUpdate
@OptimisticLocking(type = OptimisticLockType.VERSION)
@SelectBeforeUpdate
@Entity(name = "Address")
@Table(name = "Address")
data class Address(
    @Id
    @NaturalId
    @SequenceGenerator(
        sequenceName = "address_generator",
        name = "address_seq",
        allocationSize = 1,
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "address_seq",
    )
    var id: Long,

    @Column(
        length = 150,
    )
    var street: String,

    @Column(
        name = "address_line_1",
    )
    var addressLine1: String,

    @Column(
        name = "address_line_2",
    )
    var addressLine2: String,

    @Column(
        length = 150,
    )
    var city: String,

    @Column(
        length = 10,
    )
    var postalCode: String,

    @ManyToOne
    @JoinColumn(
        name = "country_id",
        foreignKey = ForeignKey(name = "country_id_fk")
    )
    var country: Country,

    @Version
    var version: Int,
)