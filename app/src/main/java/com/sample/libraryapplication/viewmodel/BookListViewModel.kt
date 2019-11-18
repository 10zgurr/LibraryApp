package com.sample.libraryapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.libraryapplication.database.entity.BookEntity
import com.sample.libraryapplication.database.entity.CategoryEntity
import com.sample.libraryapplication.repository.BookRepository
import com.sample.libraryapplication.repository.CategoryRepository

class BookListViewModel(categoryRepository: CategoryRepository, private var bookRepository: BookRepository) : ViewModel() {

    var allCategories: LiveData<List<CategoryEntity>> = categoryRepository.getCategories()
    var isLoading = MutableLiveData<Boolean>()

    fun getBooksListSelectedCategory(categoryID: Long) : LiveData<List<BookEntity>> {
        return bookRepository.getBooks(categoryID)
    }

    fun deleteBook(book: BookEntity) {
        bookRepository.deleteBook(book)
    }
}