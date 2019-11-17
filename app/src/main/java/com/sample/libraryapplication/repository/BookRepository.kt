package com.sample.libraryapplication.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.sample.libraryapplication.database.LibraryDatabase
import com.sample.libraryapplication.database.dao.BookDAO
import com.sample.libraryapplication.database.entity.BookEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookRepository(application: Application) {

    private var bookDAO: BookDAO = LibraryDatabase.getInstance(application).getBookDAO()

    fun getBooks(categoryID: Long): LiveData<List<BookEntity>> {
        return bookDAO.getCategoryBooks(categoryID)
    }

    fun insertBook(book: BookEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            bookDAO.addBook(book)
        }
    }

    fun deleteBook(book: BookEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            bookDAO.deleteBook(book)
        }
    }

    fun updateBook(book: BookEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            bookDAO.updateBook(book)
        }
    }
}