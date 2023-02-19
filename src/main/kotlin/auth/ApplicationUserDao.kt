package auth

import java.util.Optional

interface ApplicationUserDao {
	fun selectApplicationUserByUsername(username: String): Optional<ApplicationUser>
}
