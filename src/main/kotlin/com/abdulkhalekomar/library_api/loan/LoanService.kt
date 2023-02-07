package com.abdulkhalekomar.library_api.loan

import com.abdulkhalekomar.library_api.book.Book
import com.abdulkhalekomar.library_api.user.User
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class LoanService(private val loanRepository: ILoanRepository) {
	fun findAllLoans(): Iterable<Loan> = loanRepository.findAll()

	fun findLoanById(loanId: Long) = loanRepository.findById(loanId)

	fun createLoan(requestLoan: LoanRequest): ResponseEntity<LoanResponse> {
		val loan = requestLoan.toEntity()
		val book = Book(id = loan.book!!.id)
		val user = User(id = loan.user!!.id)
		loan.book = book
		loan.user = user
		return ResponseEntity.ok(loanRepository.save(loan).toResponse())
	}

	fun updateLoan(loanId: Long, loanRequest: LoanRequest): ResponseEntity<LoanResponse> {
		val findLoan = loanRepository.findById(loanId)
		if (!findLoan.isPresent) {
			return ResponseEntity.notFound().build()
		}
		val loan = findLoan.get()
		// TODO: Dates (loan and return)
		loan.loanData = loanRequest.loanData
		loan.returnData = loanRequest.returnData
		loan.book!!.id = loanRequest.book!!.id
		loan.user!!.id = loanRequest.user!!.id
		return ResponseEntity.ok(loanRepository.save(loan).toResponse())
	}

	fun deleteLoanById(loanId: Long): String {
		loanRepository.deleteById(loanId)
		if (!loanRepository.existsById(loanId)) {
			return "Loan deleted successfully"
		}
		return "Failed to delete Load with Loan id: $loanId"
	}
}
