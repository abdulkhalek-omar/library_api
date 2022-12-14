package com.abdulkhalekomar.library_api.address.address

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository : CrudRepository<Address, Long>