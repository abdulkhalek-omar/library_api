package com.abdulkhalekomar.library_api.loan

import com.abdulkhalekomar.library_api.book.Book
import com.abdulkhalekomar.library_api.user.User
import jakarta.validation.constraints.Future
import java.time.LocalDateTime

data class LoanRequest(
	val loanData: LocalDateTime = LocalDateTime.now(),
	@get:Future val returnData: LocalDateTime = LocalDateTime.now().plusDays(3),
	val user: User?,
	val book: Book?,
)

data class LoanResponse(
	val id: Long,
)

fun LoanRequest.toEntity() = Loan(
	loanData = loanData,
	returnData = returnData,
	user = user,
	book = book,
)

fun Loan.toResponse() = LoanResponse(
	id = id,
)
