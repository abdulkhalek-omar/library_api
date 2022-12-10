package com.abdulkhalekomar.library_api.langauge

import org.springframework.web.bind.annotation.RestController

@RestController
class LanguageController(private val languageService: LanguageService) {
}