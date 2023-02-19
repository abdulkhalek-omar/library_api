package com.abdulkhalekomar.library_api.auth

import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ApplicationUserDao {
	fun selectApplicationUserByUsername(username: String): Optional<ApplicationUser>
}
