package com.abdulkhalekomar.library_api.auth

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service


@Service
class ApplicationUserService
@Autowired constructor(
	@param:Qualifier("fake") private val applicationUserDao: ApplicationUserDao
) : UserDetailsService {
	@Throws(UsernameNotFoundException::class)
	override fun loadUserByUsername(username: String): UserDetails =
		applicationUserDao.selectApplicationUserByUsername(username).orElseThrow { UsernameNotFoundException(String.format("Username $username not found")) }
}
