package com.abdulkhalekomar.library_api.address.country

import jakarta.persistence.Column
import jakarta.persistence.Entity
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

// Todo: ISO 3166-1 alpha-2
@DynamicUpdate
@OptimisticLocking(type = OptimisticLockType.VERSION)
@SelectBeforeUpdate
@Entity(name = "Country")
@Table(
    name = "Country",
    uniqueConstraints = [
        UniqueConstraint(
            name = "country_name_unique",
            columnNames = ["country_name"],
        ),
    ],
)
data class Country(
    @Id
    @NaturalId
    @SequenceGenerator(
        sequenceName = "country_generator",
        name = "country_seq",
        allocationSize = 1,
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "country_generator",
    )
    var id: Int,

    @Column(
        name = "country_name",
        nullable = false,
        unique = true,
        length = 150,
    )
    var countryName: String,

    @Version
    var version: Int,
)