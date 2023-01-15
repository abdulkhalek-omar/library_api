package com.abdulkhalekomar.library_api.langauge

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
@RequestMapping("/api/v1/language")
class LanguageController(private val languageService: LanguageService) {
	@GetMapping("/all")
	fun findAllLanguages() = languageService.findAllLanguages()

	@GetMapping("/{languageId}")
	fun findLanguageById(@PathVariable languageId: Int) = languageService.findLanguageById(languageId)

	@PostMapping
	fun createLanguage(@Valid @RequestBody languageRequest: Language) = languageService.createLanguage(languageRequest)

	@PutMapping("/{languageId}")
	fun updateLanguage(@PathVariable languageId: Int, @Valid @RequestBody languageRequest: Language) = languageService.updateLanguage(languageId, languageRequest)

	@DeleteMapping("/{languageId}")
	fun deleteLangaugeById(@PathVariable languageId: Int) = languageService.deleteLangaugeById(languageId)
}
