package com.abdulkhalekomar.library_api.category

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint

@Entity(name = "Category")
@Table(
    name = "Category",
    uniqueConstraints = [
        UniqueConstraint(
            name = "category_name_unique",
            columnNames = ["category_name"],
        ),
    ],
)
data class Category(
    @Id
    @SequenceGenerator(
        sequenceName = "category_id_sequence",
        name = "category_id_sequence",
        allocationSize = 1,
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "category_id_sequence",
    )
    var id: Long,

    @Column(
        name = "category_name",
        nullable = false,
        unique = true,
        length = 150,
    )
    var categoryName: String = "",
)