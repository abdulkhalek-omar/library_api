package com.abdulkhalekomar.library_api.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface IUserRepository : JpaRepository<User, Long> {
	fun findUserByEmail(email: String): Optional<User>

	fun findByEmail(email: String): Optional<User>
}
