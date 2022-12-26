package com.abdulkhalekomar.library_api.address.address

import org.springframework.stereotype.Service
import java.util.Optional

@Service
class AddressService(private var iAddressRepository: IAddressRepository) {
    fun findAllAddresses(): Iterable<Address> = iAddressRepository.findAll()
    fun findAddressById(addressId: Long) = iAddressRepository.findById(addressId)
    fun save(requestAddress: Address): String {
        return try {
            iAddressRepository.save(requestAddress)
            "Address is successfully created"
        } catch (e: Exception) {
            "Address not created"
        }
    }

    fun update(addressId: Long, requestAddress: Address): String {
        val foundAddress = iAddressRepository.findById(addressId)
        if (foundAddress.isPresent) {
            val address = foundAddress.get()
            address.street = requestAddress.street
            address.addressLine1 = requestAddress.addressLine1
            address.addressLine2 = requestAddress.addressLine2
            address.city = requestAddress.city
            address.postalCode = requestAddress.postalCode
            address.id = requestAddress.id
            iAddressRepository.save(address)
            return "Address is successfully Updated"
        }
        return "Address does not exists"
    }

    fun delete(addressId: Long): String {
        iAddressRepository.deleteById(addressId)
        if (!iAddressRepository.existsById(addressId)) {
            return "Address successfully deleted"
        }
        return "Address does not deleted"
    }
}