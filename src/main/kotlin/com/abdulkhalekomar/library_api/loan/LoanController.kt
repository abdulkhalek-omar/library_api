package com.abdulkhalekomar.library_api.loan

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/loan")
class LoanController(private val loanService: LoanService) {
	@GetMapping("/all")
	fun findAllLoans() = loanService.findAllLoans()

	@GetMapping("/{loanId}")
	fun findLoanById(@PathVariable loanId: Long) = loanService.findLoanById(loanId)

	@PostMapping
	fun createLoan(@Valid @RequestBody loanRequest: Loan) = loanService.createLoan(loanRequest)

	@PutMapping("/{loanId}")
	fun updateLoan(@PathVariable loanId: Long, @Valid @RequestBody loanRequest: Loan) =
		loanService.updateLoan(loanId, loanRequest)

	@DeleteMapping("/{loanId}")
	fun deleteLoanById(@PathVariable loanId: Long) = loanService.deleteLoanById(loanId)
}
