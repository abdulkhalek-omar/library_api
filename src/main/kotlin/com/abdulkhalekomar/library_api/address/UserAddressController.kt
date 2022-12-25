package com.abdulkhalekomar.library_api.address

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/user-details")
class UserAddressController(private val userAddressService: UserAddressService) {

    @GetMapping
    fun findAllUserDetails() = userAddressService.findAllUserDetails()

}