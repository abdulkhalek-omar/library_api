package com.abdulkhalekomar.library_api.loan

import com.abdulkhalekomar.library_api.address.country.Country
import com.abdulkhalekomar.library_api.book.Book
import com.abdulkhalekomar.library_api.user.User
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name = "Loan")
@Table(
    name = "Loan",
    uniqueConstraints = [
        UniqueConstraint(
            name = "user_book_unique",
            columnNames = ["user_id", "book_id"],
        )
    ]
)
class Loan {
    @Id
    @SequenceGenerator(
        name = "loan_id_sequence",
        sequenceName = "loan_id_sequence",
        allocationSize = 1,
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "loan_id_sequence",
    )
    private var id = 0L

    @Column(name = "loan_data", nullable = false)
    private var loanData: LocalDateTime? = null

    @Column(name = "return_data", nullable = false)
    private var returnData: LocalDateTime? = null

    @ManyToOne
    @JoinColumn(
        name = "user_id",
        foreignKey = ForeignKey(name = "user_id_fk")
    )
    private var user = User()

    @ManyToOne
    @JoinColumn(
        name = "book_id",
        foreignKey = ForeignKey(name = "book_id_fk")
    )
    private var book = Book()


}