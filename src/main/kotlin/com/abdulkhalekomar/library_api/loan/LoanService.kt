package com.abdulkhalekomar.library_api.loan

import com.abdulkhalekomar.library_api.book.Book
import com.abdulkhalekomar.library_api.user.User
import org.springframework.stereotype.Service

@Service
class LoanService(private val loanRepository: ILoanRepository) {
	fun findAllLoans(): Iterable<Loan> = loanRepository.findAll()

	fun findLoanById(loanId: Long) = loanRepository.findById(loanId)

	fun createLoan(requestLoan: Loan): String {
		return try {
			val book = Book(id = requestLoan.book!!.id)
			val user = User(id = requestLoan.user!!.id)
			requestLoan.book = book
			requestLoan.user = user
			loanRepository.save(requestLoan)
			"Loan is created successfully"
		} catch (e: Exception) {
			"Failed to create Loan"
		}
	}

	fun updateLoan(loanId: Long, loanRequest: Loan): String {
		val findLoan = loanRepository.findById(loanId)
		if (findLoan.isPresent) {
			val loan = findLoan.get()
			// TODO: Dates (loan and return)
			loan.loanData = loanRequest.loanData
			loan.returnData = loanRequest.returnData
			loan.book!!.id = loanRequest.book!!.id
			loan.user!!.id = loanRequest.user!!.id
			loanRepository.save(loan)
			return "Loan updated successfully"
		}
		return "Failed to update Load"
	}

	fun deleteLoanById(loanId: Long): String {
		loanRepository.deleteById(loanId)
		if (!loanRepository.existsById(loanId)) {
			return "Loan deleted successfully"
		}
		return "Failed to delete Load with Loan id: $loanId"
	}
}
