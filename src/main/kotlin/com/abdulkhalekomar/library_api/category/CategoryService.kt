package com.abdulkhalekomar.library_api.category

import org.springframework.stereotype.Service


@Service
class CategoryService(private val iCategoryRepository: ICategoryRepository) {
    fun findAllCategories(): Iterable<Category> = iCategoryRepository.findAll()

    fun findCategoryById(categoryId: Long) = iCategoryRepository.findById(categoryId)

    fun createCategory(categoryRequest: Category): String {
        return try {
            iCategoryRepository.save(categoryRequest)
            "Category created successfully"
        } catch (e: Exception) {
            "Category can't be created: $e"
        }
    }

    fun updateCategory(categoryId: Long, categoryRequest: Category): String {
        val findCategory = iCategoryRepository.findById(categoryId)
        if (findCategory.isPresent) {
            val category = findCategory.get()
            category.categoryName = categoryRequest.categoryName
            iCategoryRepository.save(category)
            return "Category updated successfully"
        }
        return "Category can't updated"
    }

    fun deleteCategory(categoryId: Long): String {
        iCategoryRepository.deleteById(categoryId)
        if (!iCategoryRepository.existsById(categoryId)) {
            return "Category is successfully deleted"
        }
        return "Category can't be deleted"
    }
}