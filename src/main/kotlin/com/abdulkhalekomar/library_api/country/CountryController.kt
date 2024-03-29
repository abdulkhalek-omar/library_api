package com.abdulkhalekomar.library_api.country

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/country")
class CountryController(private val iCountryService: CountryService) {
	@GetMapping("/all")
	fun findALlCountries(): Iterable<Country> = iCountryService.findAllCountries()

	@GetMapping("/{countryId}")
	fun findCountryById(@PathVariable countryId: Int) = iCountryService.findCountryById(countryId)

	@PostMapping
	fun createCountry(@Valid @RequestBody requestCountry: CountryRequest) = iCountryService.createCountry(requestCountry)

	@PutMapping("/{countryId}")
	fun updateCountry(@PathVariable countryId: Int, @Valid @RequestBody requestCountry: CountryRequest) = iCountryService.updateCountry(countryId, requestCountry)

	@DeleteMapping("/{countryId}")
	fun deleteCountry(@PathVariable countryId: Int) = iCountryService.deleteCountry(countryId)
}
