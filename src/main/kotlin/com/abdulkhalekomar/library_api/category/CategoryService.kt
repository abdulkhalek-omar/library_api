package com.abdulkhalekomar.library_api.category

import org.springframework.stereotype.Service


@Service
class CategoryService(private val categoryRepository: ICategoryRepository) {
    fun findAllCategories(): Iterable<Category> = categoryRepository.findAll()

    fun findCategoryById(categoryId: Long) = categoryRepository.findById(categoryId)

    fun createCategory(categoryRequest: Category): String {
        return try {
            categoryRepository.save(categoryRequest)
            "Category created successfully"
        } catch (e: Exception) {
            "Category can't be created: $e"
        }
    }

    fun updateCategory(categoryId: Long, categoryRequest: Category): String {
        val findCategory = categoryRepository.findById(categoryId)
        if (findCategory.isPresent) {
            val category = findCategory.get()
            category.categoryName = categoryRequest.categoryName
            categoryRepository.save(category)
            return "Category updated successfully"
        }
        return "Category can't updated"
    }

    fun deleteCategory(categoryId: Long): String {
        categoryRepository.deleteById(categoryId)
        if (!categoryRepository.existsById(categoryId)) {
            return "Category is successfully deleted"
        }
        return "Category can't be deleted"
    }
}
