package com.abdulkhalekomar.library_api.loan

import org.springframework.data.repository.CrudRepository

interface ILoanRepository : CrudRepository<Loan, Long>