package com.abdulkhalekomar.library_api.security.enums

import org.springframework.security.core.authority.SimpleGrantedAuthority
import java.util.function.Function
import java.util.stream.Collectors

enum class ApplicationRole(private val permissions: Set<ApplicationPermission>) {
	USER(
		setOf(

		)
	),
	ADMIN(
		setOf(
			ApplicationPermission.COURSE_READ,
			ApplicationPermission.COURSE_WRITE,
			ApplicationPermission.USER_READ,
			ApplicationPermission.USER_WRITE,
		)
	),
	ADMINTRAINEE(
		setOf(
			ApplicationPermission.COURSE_READ,
			ApplicationPermission.USER_READ,
		)
	);

	fun getGrantedAuthorities(): MutableSet<SimpleGrantedAuthority> {
		val permissions = permissions.stream().map { permission -> SimpleGrantedAuthority(permission.permission) }.collect(Collectors.toSet())
		permissions.add(SimpleGrantedAuthority("ROLE_${this.name}"))
		return permissions
	}
}
