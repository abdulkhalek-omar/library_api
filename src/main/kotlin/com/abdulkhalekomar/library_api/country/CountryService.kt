package com.abdulkhalekomar.library_api.country

import org.springframework.stereotype.Service

@Service
class CountryService(private val countryRepository: ICountryRepository) {
	fun findAllCountries(): Iterable<Country> = countryRepository.findAll()
	fun findCountryById(countryId: Int) = countryRepository.findById(countryId)
	fun createCountry(requestCountry: Country): String {
		return try {
			countryRepository.save(requestCountry)
			"Country is successfully created"
		} catch (e: Exception) {
			"Country not created; request null"
		}
	}

	fun updateCountry(countryId: Int, requestCountry: Country): String {
		val foundCountry = countryRepository.findById(countryId)
		if (foundCountry.isPresent) {
			val country = foundCountry.get()
			country.countryName = requestCountry.countryName
			countryRepository.save(country)
			return "Country is successfully Updated"
		}
		return "Country does not exists"
	}

	fun deleteCountry(countryId: Int): String {
		countryRepository.deleteById(countryId)
		if (!countryRepository.existsById(countryId)) {
			return "Country is successfully deleted"
		}
		return "Country can not deleted"
	}
}
