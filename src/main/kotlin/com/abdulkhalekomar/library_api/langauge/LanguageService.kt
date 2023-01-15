package com.abdulkhalekomar.library_api.langauge

import org.springframework.stereotype.Service

@Service
class LanguageService(private val languageRepository: ILanguageRepository) {
    fun findAllLanguages(): Iterable<Language> = languageRepository.findAll()

    fun findLanguageById(languageId: Int) = languageRepository.findById(languageId)

    fun createLanguage(languageRequest: Language): Any {
        return try {
            languageRepository.save(languageRequest)
            "Language is successfully created"
        } catch (e: Exception) {
            "Language not created: $e"
        }
    }

    fun updateLanguage(languageId: Int, languageRequest: Language): String {
        val findLanguage = languageRepository.findById(languageId)
        if (findLanguage.isPresent) {
            val language = findLanguage.get()
            language.iso6391 = languageRequest.iso6391
            languageRepository.save(language)
            return "Language successfully updated"
        }
        return "Failed to update language"
    }

    fun deleteLangaugeById(languageId: Int): String {
        languageRepository.deleteById(languageId)
        if (!languageRepository.existsById(languageId)) {
            return "Language is successfully deleted"
        }
        return "Failed to delete Language"
    }
}
