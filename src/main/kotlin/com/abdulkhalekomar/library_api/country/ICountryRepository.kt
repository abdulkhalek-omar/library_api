package com.abdulkhalekomar.library_api.country

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ICountryRepository : CrudRepository<Country, Int>