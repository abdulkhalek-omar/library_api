package com.abdulkhalekomar.library_api.user

import com.abdulkhalekomar.library_api.address.IAddressRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: IUserRepository, private val iAddressRepository: IAddressRepository) {
	fun findAllUsers(): Iterable<User> = userRepository.findAll()
	fun findUserById(id: Long): User? {
		return userRepository.findById(id).orElse(null)
	}

	fun createUser(requestUser: UserRequest): ResponseEntity<UserResponse> {
		val user = requestUser.toEntity()
		val address = iAddressRepository.findById(requestUser.address!!.id).get()
		user.address = address
		return ResponseEntity.ok(userRepository.save(user).toResponse())
	}

	fun updateUserById(id: Long, requestUser: UserRequest): ResponseEntity<UserResponse> {
		val foundUser = userRepository.findById(id)
		if (!foundUser.isPresent) {
			return ResponseEntity.notFound().build()
		}
		val user = foundUser.get()
		user.firstName = requestUser.firstName
		user.lastName = requestUser.lastName
		user.phone = requestUser.phone
		user.address!!.id = requestUser.address!!.id
		return ResponseEntity.ok(userRepository.save(user).toResponse())
	}

	fun deleteUserById(id: Long): String {
		userRepository.deleteById(id)
		if (!userRepository.existsById(id)) {
			return "User successfully deleted"
		}
		return "User does not deleted"
	}
}
