package com.abdulkhalekomar.library_api.user

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface IUserRepository : CrudRepository<User, Long> {
	fun findUserByEmail(email: String): Optional<User>
	
}
