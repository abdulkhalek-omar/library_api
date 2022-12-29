package com.abdulkhalekomar.library_api.langauge

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table

@Entity(name = "Language")
@Table(name = "Language")
data class Language(
    @Id
    @SequenceGenerator(
        name = "language_id_sequence",
        sequenceName = "language_id_sequence",
        allocationSize = 1,
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "language_id_sequence",
    )
    var id: Int,

    @Column(
        name = "iso_639_1",
        nullable = false,
        length = 2,
    )
    var iso6391: String = "",
)
