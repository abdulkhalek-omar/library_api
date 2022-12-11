package com.abdulkhalekomar.library_api.author

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name = "Author")
@Table(name = "Author")
class Author {
    constructor()
    constructor(firstName: String, lastName: String, cv: String?, birthDate: LocalDateTime?) {
        this.firstName = firstName
        this.lastName = lastName
        this.cv = cv
        this.birthDate = birthDate
    }

    @Id
    @SequenceGenerator(
        name = "author_id_sequence",
        sequenceName = "author_id_sequence",
        allocationSize = 1,
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "author_id_sequence",
    )
    private var id = 0L

    @Column(
        name = "first_name",
        nullable = false,
        length = 100,
    )
    private var firstName: String = ""


    @Column(
        name = "last_name",
        nullable = false,
        length = 150,
    )
    private var lastName: String = ""

    @Column(
        name = "cv",
    )
    private var cv: String? = null

    @Column(name = "birth_date")
    private var birthDate: LocalDateTime? = null


}