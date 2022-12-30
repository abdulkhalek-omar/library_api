package com.abdulkhalekomar.library_api.langauge

import org.springframework.stereotype.Service

@Service
class LanguageService(private val iLanguageRepository: ILanguageRepository) {
    fun findAllLanguages(): Iterable<Language> = iLanguageRepository.findAll()

    fun findLanguageById(languageId: Int) = iLanguageRepository.findById(languageId)

    fun createLanguage(languageRequest: Language): Any {
        return try {
            iLanguageRepository.save(languageRequest)
            "Language is successfully created"
        } catch (e: Exception) {
            "Language not created: $e"
        }
    }

    fun updateLanguage(languageId: Int, languageRequest: Language): String {
        val findLanguage = iLanguageRepository.findById(languageId)
        if (findLanguage.isPresent) {
            val language = findLanguage.get()
            language.iso6391 = languageRequest.iso6391
            iLanguageRepository.save(language)
            return "Language successfully updated"
        }
        return "Failed to update language"
    }

    fun deleteLangaugeById(languageId: Int): String {
        iLanguageRepository.deleteById(languageId)
        if (!iLanguageRepository.existsById(languageId)) {
            return "Language is successfully deleted"
        }
        return "Failed to delete Language"
    }
}