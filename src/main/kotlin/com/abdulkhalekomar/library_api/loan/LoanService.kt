package com.abdulkhalekomar.library_api.loan

import com.abdulkhalekomar.library_api.book.Book
import com.abdulkhalekomar.library_api.user.User
import org.springframework.stereotype.Service

@Service
class LoanService(private val iLoanRepository: ILoanRepository) {
    fun findAllLoans(): Iterable<Loan> = iLoanRepository.findAll()

    fun findLoanById(loanId: Long) = iLoanRepository.findById(loanId)

    fun createLoan(requestLoan: Loan): String {
        return try {
            val book = Book(id = requestLoan.book!!.id)
            val user = User(id = requestLoan.book!!.id)
            requestLoan.book = book
            requestLoan.user = user
            iLoanRepository.save(requestLoan)
            "Loan is created successfully"
        } catch (e: Exception) {
            "Failed to create Loan"
        }
    }

    fun updateLoan(loanId: Long, loanRequest: Loan): String {
        val findLoan = iLoanRepository.findById(loanId)
        if (findLoan.isPresent) {
            val loan = findLoan.get()
            // TODO: Dates (loan and return)
            loan.loanData = loanRequest.loanData
            loan.returnData = loanRequest.returnData
            loan.book!!.id = loanRequest.book!!.id
            loan.user!!.id = loanRequest.book!!.id
            iLoanRepository.save(loan)
            return "Loan updated successfully"
        }
        return "Failed to update Load"
    }

    fun deleteLoanById(loanId: Long): String {
        iLoanRepository.deleteById(loanId)
        if (!iLoanRepository.existsById(loanId)) {
            return "Loan deleted successfully"
        }
        return "Failed to delete Load with Loan id: $loanId"
    }
}