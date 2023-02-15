package com.abdulkhalekomar.library_api.security.enums

enum class ApplicationPermission(val permission: String) {
	USER_READ("USER:READ"),
	USER_WRITE("USER:WRITE"),
	COURSE_READ("COURSE:READ"),
	COURSE_WRITE("COURSE:WRITE"),
}
