package com.abdulkhalekomar.library_api.user

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IUserRepository : CrudRepository<User, Long>