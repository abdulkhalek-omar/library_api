package com.abdulkhalekomar.library_api.loan

import com.abdulkhalekomar.library_api.book.Book
import com.abdulkhalekomar.library_api.user.User
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
import jakarta.persistence.UniqueConstraint
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

@Entity(name = "Loan")
@Table(
    name = "Loan", uniqueConstraints = [UniqueConstraint(
        name = "user_book_unique",
        columnNames = ["user_id", "book_id"],
    )]
)
data class Loan(
    @Id @SequenceGenerator(
        name = "loan_id_sequence",
        sequenceName = "loan_id_sequence",
        allocationSize = 1,
    ) @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "loan_id_sequence",
    ) var id: Long,

    @Column(
        name = "loan_data",
        nullable = false,
    ) @NotBlank @DateFormat var loanData: LocalDateTime = LocalDateTime.now(),

    @Column(
        name = "return_data",
        nullable = false,
    ) @NotBlank @DateFormat @Future var returnData: LocalDateTime = LocalDateTime.now().plusDays(3),

    @ManyToOne @JoinColumn(
        name = "user_id", foreignKey = ForeignKey(name = "user_id_fk")
    ) var user: User? = null,

    @ManyToOne @JoinColumn(
        name = "book_id", foreignKey = ForeignKey(name = "book_id_fk")
    ) var book: Book? = null,
)