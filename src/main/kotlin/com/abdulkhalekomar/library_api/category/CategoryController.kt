package com.abdulkhalekomar.library_api.category

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
@RequestMapping("/api/v1/category")
class CategoryController(private val categoryService: CategoryService) {
	@GetMapping("/all")
	fun findAllCategories() = categoryService.findAllCategories()

	@GetMapping("/{categoryId}")
	fun findCategoryById(@PathVariable categoryId: Long) = categoryService.findCategoryById(categoryId)

	@PostMapping
	fun createCategory(@Valid @RequestBody categoryRequest: Category) = categoryService.createCategory(categoryRequest)

	@PutMapping("/{categoryId}")
	fun updateCategory(@PathVariable categoryId: Long, @Valid @RequestBody categoryRequest: Category) =
		categoryService.updateCategory(categoryId, categoryRequest)

	@DeleteMapping("/{categoryId}")
	fun deleteCategory(@PathVariable categoryId: Long) = categoryService.deleteCategory(categoryId)
}
