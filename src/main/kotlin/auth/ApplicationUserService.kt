package auth

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class ApplicationUserService(
	private val applicationUserDao: ApplicationUserDao,
) : UserDetailsService {
	override fun loadUserByUsername(username: String): UserDetails =
		applicationUserDao.selectApplicationUserByUsername(username).orElseThrow { UsernameNotFoundException(String.format("Username $username not found")) }
}
