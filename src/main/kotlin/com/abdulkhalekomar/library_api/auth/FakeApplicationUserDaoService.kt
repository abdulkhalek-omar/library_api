package com.abdulkhalekomar.library_api.auth

import com.abdulkhalekomar.library_api.security.enums.ApplicationRole
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository
import java.util.*

@Repository("fake")
class FakeApplicationUserDaoService(
	private val passwordEncoder: PasswordEncoder,
) : ApplicationUserDao {
	override fun selectApplicationUserByUsername(username: String): Optional<ApplicationUser> =
		getApplicationUsers().stream().filter { applicationUsers -> username == applicationUsers.username }.findFirst()

	private fun getApplicationUsers(): List<ApplicationUser> {
		return listOf(
			ApplicationUser(
				username = "admin",
				password = passwordEncoder.encode("password"),
				grantedAuthority = ApplicationRole.ADMIN.getGrantedAuthorities(),
				isAccountNonExpired = true,
				isAccountNonLocked = true,
				isCredentialsNonExpired = true,
				isEnabled = true,
			),
			ApplicationUser(
				username = "admin_trainee",
				password = passwordEncoder.encode("password"),
				grantedAuthority = ApplicationRole.ADMIN.getGrantedAuthorities(),
				isAccountNonExpired = true,
				isAccountNonLocked = true,
				isCredentialsNonExpired = true,
				isEnabled = true,
			),
			ApplicationUser(
				username = "user",
				password = passwordEncoder.encode("password"),
				grantedAuthority = ApplicationRole.ADMIN.getGrantedAuthorities(),
				isAccountNonExpired = true,
				isAccountNonLocked = true,
				isCredentialsNonExpired = true,
				isEnabled = true,
			),
		)
	}
}

