package com.abdulkhalekomar.library_api.country

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CountryService(private val countryRepository: ICountryRepository) {
	fun findAllCountries(): Iterable<Country> = countryRepository.findAll()
	fun findCountryById(countryId: Int) = countryRepository.findById(countryId)
	fun createCountry(requestCountry: CountryRequest): ResponseEntity<CountryResponse> {
		val country = countryRepository.save(requestCountry.toEntity())
		return ResponseEntity.ok(country.toResponse())
	}

	fun updateCountry(countryId: Int, requestCountry: CountryRequest): ResponseEntity<CountryResponse> {
		val foundCountry = countryRepository.findById(countryId)
		if (!foundCountry.isPresent) {
			return ResponseEntity.notFound().build()
		}
		val country = foundCountry.get()
		country.countryName = requestCountry.countryName
		return ResponseEntity.ok(countryRepository.save(country).toResponse())
	}

	fun deleteCountry(countryId: Int): String {
		countryRepository.deleteById(countryId)
		if (!countryRepository.existsById(countryId)) {
			return "Country is successfully deleted"
		}
		return "Country can not deleted"
	}
}
