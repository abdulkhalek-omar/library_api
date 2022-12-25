package com.abdulkhalekomar.library_api.user

import org.springframework.stereotype.Service

@Service
class UserService(private val iUserRepository: IUserRepository) {
    fun findAllUsers(): Iterable<User> = iUserRepository.findAll()
    fun findUserById(id: Long): User? {
        return iUserRepository.findById(id).orElse(null)
    }

    fun save(requestUser: User): String {
        val savedUser = iUserRepository.save(requestUser)
        if (savedUser.id != null) {
            return "User successfully created"
        }
        return "Failed to created User"
    }

    fun updateUserById(id: Long, requestUser: User): String {
        val foundUser = iUserRepository.findById(id)
        if (foundUser.isPresent) {
            val user = foundUser.get()
            user.firstName = requestUser.firstName
            user.lastName = requestUser.lastName
            iUserRepository.save(user)
            return "User is successfully Updated"
        }
        return "User does not exists"
    }

    fun deleteUserById(id: Long): String {
        iUserRepository.deleteById(id)
        if (!iUserRepository.existsById(id)) {
            return "User successfully deleted"
        }
        return "User does not deleted"
    }
}