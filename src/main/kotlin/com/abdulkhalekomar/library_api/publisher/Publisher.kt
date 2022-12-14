package com.abdulkhalekomar.library_api.publisher

import jakarta.persistence.*

@Entity(name = "Publisher")
@Table(name = "Publisher")
class Publisher {
    constructor()
    constructor(publisherName: String) {
        this.publisherName = publisherName
    }

    @Id
    @SequenceGenerator(
        sequenceName = "publisher_id_sequence",
        name = "publisher_id_sequence",
        allocationSize = 1,
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "publisher_id_sequence",
    )
    private var id = 0L

    @Column(
        name = "publisher_name",
        nullable = false,
    )
    private var publisherName = ""
}