package com.abdulkhalekomar.library_api.category

import org.springframework.web.bind.annotation.RestController

@RestController
class CategoryController(private val categoryService: CategoryService) {
}