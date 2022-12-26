package com.abdulkhalekomar.library_api.address

import org.springframework.stereotype.Service
import java.util.*

@Service
class UserAddressService(private val iUserAddressRepository: IUserAddressRepository) {
    fun findAllUserDetails(): List<UserAddress> = iUserAddressRepository.findAll()
    fun findById(id: Long): Optional<UserAddress> = iUserAddressRepository.findById(id)
    fun getUserAddressByUserId(userId: Long) = iUserAddressRepository.getUserAddressByUserId(userId)
    fun getUserAddressByAddressId(addressId: Long) = iUserAddressRepository.getUserAddressByAddressId(addressId)

}