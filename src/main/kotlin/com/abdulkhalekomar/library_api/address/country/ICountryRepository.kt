package com.abdulkhalekomar.library_api.address.country

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ICountryRepository : CrudRepository<Country, Int>