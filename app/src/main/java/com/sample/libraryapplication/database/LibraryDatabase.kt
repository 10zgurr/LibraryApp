package com.sample.libraryapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sample.libraryapplication.database.dao.BookDAO
import com.sample.libraryapplication.database.dao.CategoryDAO
import com.sample.libraryapplication.database.entity.BookEntity
import com.sample.libraryapplication.database.entity.CategoryEntity

@Database(entities = [CategoryEntity::class, BookEntity::class], version = 1)
abstract class LibraryDatabase : RoomDatabase() {

    abstract fun getCategoryDAO(): CategoryDAO
    abstract fun getBookDAO(): BookDAO
}