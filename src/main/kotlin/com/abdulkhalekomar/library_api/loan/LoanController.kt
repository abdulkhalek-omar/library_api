package com.abdulkhalekomar.library_api.loan

import org.springframework.web.bind.annotation.RestController

@RestController
class LoanController(private val loanService: LoanService) {
}