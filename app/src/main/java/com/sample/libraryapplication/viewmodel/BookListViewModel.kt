package com.sample.libraryapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.sample.libraryapplication.database.entity.BookEntity
import com.sample.libraryapplication.database.entity.CategoryEntity
import com.sample.libraryapplication.repository.BookRepository
import com.sample.libraryapplication.repository.CategoryRepository

class BookListViewModel(application: Application): AndroidViewModel(application) {

    private var categoryRepository = CategoryRepository()
    private var bookRepository = BookRepository()

    var allCategories: LiveData<List<CategoryEntity>> = categoryRepository.getCategories()

    fun getBooksListSelectedCategory(categoryID: Long) : LiveData<List<BookEntity>> {
        return bookRepository.getBooks(categoryID)
    }

    fun deleteBook(book: BookEntity) {
        bookRepository.deleteBook(book)
    }
}