package com.abdulkhalekomar.library_api.langauge

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class LanguageService(private val languageRepository: ILanguageRepository) {
	fun findAllLanguages(): Iterable<Language> = languageRepository.findAll()

	fun findLanguageById(languageId: Int) = languageRepository.findById(languageId)

	fun createLanguage(languageRequest: LanguageRequest): ResponseEntity<LanguageResponse> {
		val language = languageRepository.save(languageRequest.toEntity())
		return ResponseEntity.ok(language.toResponse())
	}

	fun updateLanguage(languageId: Int, languageRequest: LanguageRequest): ResponseEntity<LanguageResponse> {
		val findLanguage = languageRepository.findById(languageId)
		if (!findLanguage.isPresent) {
			return ResponseEntity.notFound().build()
		}
		val language = findLanguage.get()
		language.iso6391 = languageRequest.iso6391
		return ResponseEntity.ok(language.toResponse())
	}

	fun deleteLangaugeById(languageId: Int): String {
		languageRepository.deleteById(languageId)
		if (!languageRepository.existsById(languageId)) {
			return "Language is successfully deleted"
		}
		return "Failed to delete Language"
	}
}
