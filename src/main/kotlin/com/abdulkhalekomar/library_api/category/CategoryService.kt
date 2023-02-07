package com.abdulkhalekomar.library_api.category

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service


@Service
class CategoryService(private val categoryRepository: ICategoryRepository) {
	fun findAllCategories(): Iterable<Category> = categoryRepository.findAll()

	fun findCategoryById(categoryId: Long) = categoryRepository.findById(categoryId)

	fun createCategory(categoryRequest: CategoryRequest): ResponseEntity<CategoryResponse> {
		val category = categoryRepository.save(categoryRequest.toEntity())
		return ResponseEntity.ok(category.toResponse())
	}

	fun updateCategory(categoryId: Long, categoryRequest: CategoryRequest): ResponseEntity<CategoryResponse> {
		val findCategory = categoryRepository.findById(categoryId)
		if (findCategory.isPresent) {
			return ResponseEntity.notFound().build()
		}
		val category = findCategory.get()
		category.categoryName = categoryRequest.categoryName
		categoryRepository.save(category)
		return ResponseEntity.ok(categoryRepository.save(category).toResponse())
	}

	fun deleteCategory(categoryId: Long): String {
		categoryRepository.deleteById(categoryId)
		if (!categoryRepository.existsById(categoryId)) {
			return "Category is successfully deleted"
		}
		return "Category can't be deleted"
	}
}
