package com.abdulkhalekomar.library_api.address.country

import org.springframework.stereotype.Service

@Service
class CountryService(private val iCountryRepository: ICountryRepository) {
    fun findAllCountries(): Iterable<Country> = iCountryRepository.findAll()
    fun findCountryById(countryId: Int) = iCountryRepository.findById(countryId)
    fun createCountry(requestCountry: Country): String {
        return try {
            iCountryRepository.save(requestCountry)
            "Country is successfully created"
        } catch (e: Exception) {
            "Country not created; request null"
        }
    }

    fun updateCountry(countryId: Int, requestCountry: Country): String {
        val foundCountry = iCountryRepository.findById(countryId)
        if (foundCountry.isPresent) {
            val country = foundCountry.get()
            country.countryName = requestCountry.countryName
            iCountryRepository.save(country)
            return "Country is successfully Updated"
        }
        return "Country does not exists"
    }

    fun deleteCountry(countryId: Int): String {
        iCountryRepository.deleteById(countryId)
        if (!iCountryRepository.existsById(countryId)) {
            return "Country is successfully deleted"
        }
        return "Country can not deleted"
    }
}