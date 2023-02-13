package com.abdulkhalekomar.library_api.security.enums

enum class ApplicationPermission(private val permission: String) {
	USER_READ("user:read"),
	USER_WRITE("user:write"),
	COURSE_READ("course:read"),
	COURSE_WRITE("course:write");

	fun getPermission(): String {
		return permission
	}
}
