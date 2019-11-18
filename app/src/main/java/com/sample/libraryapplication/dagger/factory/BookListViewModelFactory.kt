package com.sample.libraryapplication.dagger.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sample.libraryapplication.repository.BookRepository
import com.sample.libraryapplication.repository.CategoryRepository
import com.sample.libraryapplication.viewmodel.BookListViewModel
import javax.inject.Inject

class BookListViewModelFactory @Inject constructor(private var categoryRepository: CategoryRepository,
                                                   private var bookRepository: BookRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BookListViewModel(categoryRepository, bookRepository) as T
    }
}