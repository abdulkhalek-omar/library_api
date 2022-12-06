package com.abdulkhalekomar.library_api.author

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name = "Author")
@Table(name = "Author")
class Author {
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
    private val id = 0L

    @Column(name = "first_name", nullable = false)
    private val firstName: String = ""


    @Column(name = "last_name", nullable = false)
    private val lastName: String = ""

    @Column(name = "cv")
    private val cv: String? = null

    @Column(name = "birth_date")
    private val birthDate: LocalDateTime? = null


}