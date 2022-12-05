package com.abdulkhalekomar.library_api.author

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name = "Author")
@Table(name = "Author")
class Author {
    @Id
    @SequenceGenerator(
        name = "author_sequence",
        sequenceName = "author_sequence",
        allocationSize = 1,
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "author_sequence",
    )
    private val id = 0L

    @Column(name = "first_name", nullable = false)
    var firstName: String = ""


    @Column(name = "last_name", nullable = false)
    var lastName: String = ""

    @Column(name = "cv")
    var cv: String? = null

    @Column(name = "birth_date")
    var birthDate: LocalDateTime? = null


}