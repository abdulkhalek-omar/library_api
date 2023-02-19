package com.abdulkhalekomar.library_api.auth

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class ApplicationUser(
	private val username: String,
	private val password: String,
	private val grantedAuthority: MutableSet<out GrantedAuthority>,
	private val isAccountNonExpired: Boolean,
	private val isAccountNonLocked: Boolean,
	private val isCredentialsNonExpired: Boolean,
	private val isEnabled: Boolean,
) : UserDetails {
	override fun getAuthorities(): MutableCollection<out GrantedAuthority> = grantedAuthority
	override fun getPassword(): String = password
	override fun getUsername(): String = username
	override fun isAccountNonExpired(): Boolean = isAccountNonExpired
	override fun isAccountNonLocked(): Boolean = isAccountNonLocked
	override fun isCredentialsNonExpired(): Boolean = isCredentialsNonExpired
	override fun isEnabled(): Boolean = isEnabled
}
