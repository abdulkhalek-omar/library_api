package com.abdulkhalekomar.library_api.publisher

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table

@Entity(name = "Publisher")
@Table(name = "Publisher")
data class Publisher(
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
    var id: Long,

    @Column(
        name = "publisher_name",
        nullable = false,
    )
    var publisherName: String = "",
)