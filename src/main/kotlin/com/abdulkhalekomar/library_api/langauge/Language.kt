package com.abdulkhalekomar.library_api.langauge

import jakarta.persistence.*

@Entity(name = "Language")
@Table(name = "Language")
class Language {
    constructor()
    constructor(iso6391: String) {
        this.iso6391 = iso6391
    }

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
    private var id = 0L

    @Column(name = "iso_639_1")
    private var iso6391: String = ""

}
