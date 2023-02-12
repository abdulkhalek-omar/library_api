package com.abdulkhalekomar.library_api.security.enums

enum class ApplicationRole(private val permissions: Set<ApplicationPermission>) {
	USER(setOf()),
	ADMIN(
		setOf(
			ApplicationPermission.COURSE_READ,
			ApplicationPermission.COURSE_WRITE,
			ApplicationPermission.USER_READ,
			ApplicationPermission.USER_WRITE
		)
	)
}

