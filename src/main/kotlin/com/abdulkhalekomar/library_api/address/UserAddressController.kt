package com.abdulkhalekomar.library_api.address

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/user-details")
class UserAddressController(private val userAddressService: UserAddressService) {

    @GetMapping("/all")
    fun findAllUserDetails() = userAddressService.findAllUserDetails()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) = userAddressService.findById(id)

    @GetMapping("/user/{userId}")
    fun getUserAddressByUserId(@PathVariable userId: Long) = userAddressService.getUserAddressByUserId(userId)

    @GetMapping("/address/{addressId}")
    fun getUserAddressByAddressId(@PathVariable addressId: Long) = userAddressService.getUserAddressByAddressId(addressId)
}