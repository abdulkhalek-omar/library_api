package com.abdulkhalekomar.library_api.loan

import org.springframework.data.repository.CrudRepository

interface LoanRepository : CrudRepository<Loan, Long>