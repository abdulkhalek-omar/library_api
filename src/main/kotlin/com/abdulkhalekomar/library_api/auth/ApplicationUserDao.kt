package com.abdulkhalekomar.library_api.auth

import java.util.*

interface ApplicationUserDao {
	fun selectApplicationUserByUsername(username: String): Optional<ApplicationUser>
}
