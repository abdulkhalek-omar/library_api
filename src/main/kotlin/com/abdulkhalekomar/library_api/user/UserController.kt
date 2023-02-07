package com.abdulkhalekomar.library_api.user

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/users")
class UserController(private val userService: UserService) {

	@GetMapping
	fun findAllUsers(): Iterable<User> = userService.findAllUsers()

	@GetMapping("/{userId}")
	fun findUserById(@PathVariable userId: Long): User? = userService.findUserById(userId)

	@PostMapping
	fun createUser(@Valid @RequestBody requestUser: UserRequest) = userService.createUser(requestUser)

	@PutMapping("/{userId}")
	fun updateUser(@PathVariable userId: Long, @Valid @RequestBody requestUser: UserRequest) = userService.updateUserById(userId, requestUser)

	@DeleteMapping("/{userId}")
	fun deleteUserById(@PathVariable userId: Long) = userService.deleteUserById(userId)
}
