package com.sample.libraryapplication.dagger.builders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sample.libraryapplication.repository.BookRepository
import com.sample.libraryapplication.viewmodel.BookViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookViewModelFactory @Inject constructor(private var bookRepository: BookRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BookViewModel(bookRepository)  as T
    }
}