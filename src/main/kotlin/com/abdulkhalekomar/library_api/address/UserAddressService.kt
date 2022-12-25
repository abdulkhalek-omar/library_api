package com.abdulkhalekomar.library_api.address

import org.springframework.stereotype.Service

@Service
class UserAddressService(private val iUserAddressRepository: IUserAddressRepository) {
    fun findAllUserDetails(): List<UserAddress> = iUserAddressRepository.findAll()
}