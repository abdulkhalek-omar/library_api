package com.abdulkhalekomar.library_api.address.country

import jakarta.persistence.*

// Todo: ISO 3166-1 alpha-2
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
class Country {
    constructor()
    constructor(countryName: String) {
        this.countryName = countryName
    }

    @Id
    @SequenceGenerator(
        sequenceName = "country_id_sequence",
        name = "country_id_sequence",
        allocationSize = 1,
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "country_id_sequence",
    )
    private var id: Int = 0

    @Column(
        name = "country_name",
        nullable = false,
        unique = true,
        length = 150,
    )
    private var countryName = ""

}