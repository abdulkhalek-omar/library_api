package com.abdulkhalekomar.library_api.auth

import java.util.Optional

interface ApplicationUserDao {
	fun selectApplicationUserByUsername(username: String): Optional<ApplicationUser>
}
