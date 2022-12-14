package com.abdulkhalekomar.library_api.address.address

import com.abdulkhalekomar.library_api.address.country.Country
import jakarta.persistence.*

@Entity(name = "Address")
@Table(name = "Address")
class Address {
    constructor()
    constructor(
        street: String?,
        addressLine1: String?,
        addressLine2: String?,
        city: String?,
        postalCode: String?,
        country: Country,
    ) {
        this.street = street
        this.addressLine1 = addressLine1
        this.addressLine2 = addressLine2
        this.city = city
        this.postalCode = postalCode
        this.country = country
    }

    @Id
    @SequenceGenerator(
        sequenceName = "address_id_sequence",
        name = "address_id_sequence",
        allocationSize = 1,
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "address_id_sequence",
    )
    private var id = 0L

    @Column(
        name = "street",
        length = 150,
    )
    private var street: String? = null

    @Column(
        name = "address_line_1",
    )
    private var addressLine1: String? = null

    @Column(
        name = "address_line_2",
    )
    private var addressLine2: String? = null

    @Column(
        name = "city",
        length = 150,
    )
    private var city: String? = null

    @Column(
        name = "postal_code",
        length = 10,
    )
    private var postalCode: String? = null

    @ManyToOne
    @JoinColumn(
        name = "country_id",
        foreignKey = ForeignKey(name = "country_id_fk")
    )
    private var country: Country = Country()

}