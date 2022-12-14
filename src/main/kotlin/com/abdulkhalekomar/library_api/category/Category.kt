package com.abdulkhalekomar.library_api.category

import jakarta.persistence.*

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
class Category {
    constructor()
    constructor(categoryName: String) {
        this.categoryName = categoryName
    }

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
    private var id = 0L

    @Column(
        name = "category_name",
        nullable = false,
        unique = true,
        length = 150,
    )
    private var categoryName = ""

}