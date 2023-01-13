package com.abdulkhalekomar.library_api.address

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class AddressService(private var addressRepository: IAddressRepository) {
	fun findAllAddresses(): Iterable<Address> = addressRepository.findAll()
	fun findAddressById(addressId: Long) = addressRepository.findById(addressId)
	fun createAddress(requestAddress: Address): ResponseEntity<String> {
		addressRepository.save(requestAddress)
		return ResponseEntity.ok("Address is Valid")
	}

	fun update(addressId: Long, requestAddress: Address): String {
		val foundAddress = addressRepository.findById(addressId)
		if (foundAddress.isPresent) {
			val address = foundAddress.get()
			address.street = requestAddress.street
			address.addressLine1 = requestAddress.addressLine1
			address.addressLine2 = requestAddress.addressLine2
			address.city = requestAddress.city
			address.postalCode = requestAddress.postalCode
			address.id = requestAddress.id
			addressRepository.save(address)
			return "Address is successfully Updated"
		}
		return "Address does not exists"
	}

	fun delete(addressId: Long): String {
		addressRepository.deleteById(addressId)
		if (!addressRepository.existsById(addressId)) {
			return "Address successfully deleted"
		}
		return "Address does not deleted"
	}
}
