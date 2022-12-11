package com.abdulkhalekomar.library_api.category

import jakarta.persistence.*

@Entity(name = "Category")
@Table(name = "Category")
class Category {
    constructor()
    constructor(categoryName: String) {
        this.categoryName = categoryName
    }

    @Id
    @SequenceGenerator(
        sequenceName = "category_sequence",
        name = "category_sequence",
        allocationSize = 1,
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "category_sequence",
    )
    private var id = 0L

    @Column(
        name = "category_name",
        nullable = false,
        length = 150,
    )
    private var categoryName = ""

}