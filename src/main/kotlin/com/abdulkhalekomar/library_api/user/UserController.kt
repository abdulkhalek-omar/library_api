package com.abdulkhalekomar.library_api.user

import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(private val userService: UserService) {
}