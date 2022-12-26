package com.abdulkhalekomar.library_api.address

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IUserAddressRepository : JpaRepository<UserAddress, Long> {
    fun getUserAddressByUserId(userId: Long): UserAddress
    fun getUserAddressByAddressId(addressId: Long): UserAddress
}