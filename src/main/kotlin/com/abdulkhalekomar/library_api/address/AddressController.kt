package com.abdulkhalekomar.library_api.address

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/address")
class AddressController(private val addressService: AddressService) {
    @GetMapping("all")
    fun findAllAddresses() = addressService.findAllAddresses()

    @GetMapping("/{addressId}")
    fun findAddressById(@PathVariable addressId: Long) = addressService.findAddressById(addressId)

    @PostMapping
    fun createAddress(@Valid @RequestBody requestAddress: Address): ResponseEntity<Any> {
        try {
            addressService.createAddress(requestAddress)
        } catch (ex: MethodArgumentNotValidException) {
            return ResponseEntity.ok().body("Address created successfully")
        }
        return ResponseEntity.ok().body("Address created successfully")
    }

    @PutMapping("/{addressId}")
    fun updateAddress(@PathVariable addressId: Long, @RequestBody requestAddress: Address) =
        addressService.update(addressId, requestAddress)

    @DeleteMapping("/{addressId}")
    fun deleteAddress(@PathVariable addressId: Long) = addressService.delete(addressId)
}