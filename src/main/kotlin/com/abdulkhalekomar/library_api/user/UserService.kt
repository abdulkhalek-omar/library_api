package com.abdulkhalekomar.library_api.user

import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun findAllUsers(): Iterable<User> = userRepository.findAll()
    fun findUserById(id: Long): User? {
        return userRepository.findById(id).orElse(null)
    }

    fun save(requestUser: User): String {
        val savedUser = userRepository.save(requestUser)
        if (savedUser.id != null) {
            return "User successfully created"
        }
        return "Failed to created User"
    }

    fun updateUserById(id: Long, requestUser: User): String {
        val foundUser = userRepository.findById(id)
        if (foundUser.isPresent) {
            val user = foundUser.get()
            user.firstName = requestUser.firstName
            user.lastName = requestUser.lastName
            userRepository.save(user)
            return "User is successfully Updated"
        }
        return "User does not exists"
    }

    fun deleteUserById(id: Long): String {
        userRepository.deleteById(id)
        if (!userRepository.existsById(id)) {
            return "User successfully deleted"
        }
        return "User does not deleted"
    }
}