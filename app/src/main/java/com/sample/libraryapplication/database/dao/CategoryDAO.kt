package com.sample.libraryapplication.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sample.libraryapplication.database.entity.CategoryEntity

@Dao
interface CategoryDAO {
    @Insert
    fun addCategory(category: CategoryEntity) : Long

    @Update
    fun updateCategory(category: CategoryEntity)

    @Delete
    fun deleteCategory(category: CategoryEntity?)

    @Query("SELECT * FROM categories")
    fun getAllCategories() : LiveData<List<CategoryEntity>>

    @Query("SELECT * FROM categories WHERE category_id == :categoryID")
    fun getCategory(categoryID: Long) : CategoryEntity?
}