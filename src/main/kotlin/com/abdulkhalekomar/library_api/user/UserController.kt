package com.abdulkhalekomar.library_api.user

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
    fun createUser(@RequestBody requestUser: User) = userService.save(requestUser)

    @PutMapping("/{userId}")
    fun updateUser(@PathVariable userId: Long, @RequestBody requestUser: User) =
        userService.updateUserById(userId, requestUser)

    @DeleteMapping("/{userId}")
    fun deleteUserById(@PathVariable userId: Long) = userService.deleteUserById(userId)
}