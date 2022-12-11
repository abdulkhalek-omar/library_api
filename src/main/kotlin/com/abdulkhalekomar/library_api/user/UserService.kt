package com.abdulkhalekomar.library_api.user

import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
}