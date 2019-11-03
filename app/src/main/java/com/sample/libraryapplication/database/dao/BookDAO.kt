package com.sample.libraryapplication.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sample.libraryapplication.database.entity.BookEntity

@Dao
interface BookDAO {
    @Insert
    fun addBook(book: BookEntity) : Long

    @Update
    fun updateBook(book: BookEntity)

    @Delete
    fun deleteBook(book: BookEntity?)

    @Query("SELECT * FROM books")
    fun getAllBooks() : LiveData<List<BookEntity>>

    @Query("SELECT * FROM books WHERE book_category_id == :categoryID")
    fun getCategoryBooks(categoryID: Long) : LiveData<List<BookEntity>>
}