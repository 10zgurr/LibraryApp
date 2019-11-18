package com.sample.libraryapplication.repository

import androidx.lifecycle.LiveData
import com.sample.libraryapplication.database.LibraryDatabase
import com.sample.libraryapplication.database.dao.CategoryDAO
import com.sample.libraryapplication.database.entity.CategoryEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryRepository(libraryDatabase: LibraryDatabase) {

    private var categoryDAO: CategoryDAO = libraryDatabase.getCategoryDAO()

    fun getCategories(): LiveData<List<CategoryEntity>> {
        return categoryDAO.getAllCategories()
    }

    fun insertCategory(category: CategoryEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            categoryDAO.addCategory(category)
        }
    }

    fun deleteCategory(category: CategoryEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            categoryDAO.deleteCategory(category)
        }
    }

    fun updateCategory(category: CategoryEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            categoryDAO.updateCategory(category)
        }
    }
}