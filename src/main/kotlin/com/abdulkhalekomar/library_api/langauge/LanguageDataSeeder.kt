package com.abdulkhalekomar.library_api.langauge

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class LanguageDataSeeder(private val languageRepository: ILanguageRepository) : CommandLineRunner {
	override fun run(vararg args: String?) {
		val languages = mutableListOf(
			Language(iso6391 = "ar"),
			Language(iso6391 = "de"),
			Language(iso6391 = "en"),
		)

		val languagesFromDB = languageRepository.findAll().map { it.iso6391 }

		languagesFromDB.forEach { languageDB ->
			languages.removeIf { languageDB.equals(it.iso6391) }
		}

		languageRepository.saveAll(languages)

	}

}
