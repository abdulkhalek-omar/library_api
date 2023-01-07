package com.abdulkhalekomar.library_api.author

import com.abdulkhalekomar.library_api.address.Address
import com.abdulkhalekomar.library_api.validation_helpers.annotations.DateFormat
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import jakarta.validation.constraints.Size
import org.jetbrains.annotations.NotNull
import java.time.LocalDateTime

@Entity(name = "Author")
@Table(name = "Author")
data class Author(
    @Id @SequenceGenerator(
        name = "author_id_sequence",
        sequenceName = "author_id_sequence",
        allocationSize = 1,
    ) @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "author_id_sequence",
    ) var id: Long,

    @Column(
        name = "first_name",
        nullable = false,
        length = 100,
    ) @NotNull @Size(min = 2, max = 100) var firstName: String = "",


    @Column(
        name = "last_name",
        nullable = false,
        length = 150,
    ) @NotNull @Size(min = 2, max = 150) var lastName: String = "",

    @Column(
        name = "cv",
    ) var cv: String? = null,

    @Column(name = "birth_date") @DateFormat var birthDate: LocalDateTime? = null,

    @ManyToOne @JoinColumn(
        name = "address_id", foreignKey = ForeignKey(name = "address_id_author_fk")
    ) var address: Address? = null,
)