package com.abdulkhalekomar.library_api.address

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IAddressRepository : CrudRepository<Address, Long>