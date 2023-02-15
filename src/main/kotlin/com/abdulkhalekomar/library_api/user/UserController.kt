package com.abdulkhalekomar.library_api.user

import jakarta.validation.Valid
import org.springframework.security.access.prepost.PreAuthorize
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

	// hasRole('ROLE_') hasAnyRole('ROLE_') hasAuthority('permission') hasAnyAuthority('permission')
	@GetMapping
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
	fun findAllUsers(): Iterable<User> = userService.findAllUsers()

	@GetMapping("/{userId}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
	fun findUserById(@PathVariable userId: Long): User? = userService.findUserById(userId)

	@PostMapping
	@PreAuthorize("hasAuthority('COURSE:WRITE')")
	fun createUser(@Valid @RequestBody requestUser: UserRequest) = userService.createUser(requestUser)

	@PutMapping("/{userId}")
	@PreAuthorize("hasAuthority('COURSE:WRITE')")
	fun updateUser(@PathVariable userId: Long, @Valid @RequestBody requestUser: UserRequest) = userService.updateUserById(userId, requestUser)

	@DeleteMapping("/{userId}")
	@PreAuthorize("hasAuthority('COURSE:WRITE')")
	fun deleteUserById(@PathVariable userId: Long) = userService.deleteUserById(userId)
}
