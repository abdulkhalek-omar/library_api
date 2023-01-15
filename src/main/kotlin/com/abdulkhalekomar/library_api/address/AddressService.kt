package com.abdulkhalekomar.library_api.address

import org.springframework.stereotype.Service

@Service
class AddressService(private var addressRepository: IAddressRepository) {
	fun findAllAddresses(): Iterable<Address> = addressRepository.findAll()
	fun findAddressById(addressId: Long) = addressRepository.findById(addressId)
	fun createAddress(requestAddress: Address) = addressRepository.save(requestAddress)

	fun update(addressId: Long, requestAddress: Address) {
		val foundAddress = addressRepository.findById(addressId)
		if (foundAddress.isPresent) {
			val address = foundAddress.get()
			address.street = requestAddress.street
			address.addressLine1 = requestAddress.addressLine1
			address.addressLine2 = requestAddress.addressLine2
			address.city = requestAddress.city
			address.postalCode = requestAddress.postalCode
			addressRepository.save(address)
		}
	}

	fun delete(addressId: Long): String {
		addressRepository.deleteById(addressId)
		if (!addressRepository.existsById(addressId)) {
			return "Address successfully deleted"
		}
		return "Address does not deleted"
	}
}
