package com.sample.libraryapplication.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "category_id")
    var categoryID: Long,
    @ColumnInfo(name = "category_name")
    var categoryName: String,
    @ColumnInfo(name = "category_description")
    var categoryDesc: String) {

    // for spinner
    override fun toString(): String {
        return categoryName
    }
}