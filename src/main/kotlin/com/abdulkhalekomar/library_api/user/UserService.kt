package com.abdulkhalekomar.library_api.user

import com.abdulkhalekomar.library_api.address.IAddressRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: IUserRepository, private val iAddressRepository: IAddressRepository) {
	fun findAllUsers(): Iterable<User> = userRepository.findAll()
	fun findUserById(id: Long): User? {
		return userRepository.findById(id).orElse(null)
	}

	fun createUser(requestUser: User): String {
		return try {
			val address = iAddressRepository.findById(requestUser.address!!.id).get()
			requestUser.address = address
			userRepository.save(requestUser)
			"User successfully created"
		} catch (e: Exception) {
			"Failed to created User: $e"
		}
	}

	fun updateUserById(id: Long, requestUser: User): String {
		val foundUser = userRepository.findById(id)
		if (foundUser.isPresent) {
			val user = foundUser.get()
			user.firstName = requestUser.firstName
			user.lastName = requestUser.lastName
			user.phone = requestUser.phone
			user.address!!.id = requestUser.address!!.id
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
