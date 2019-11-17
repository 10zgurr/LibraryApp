package com.sample.libraryapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.libraryapplication.database.entity.BookEntity
import com.sample.libraryapplication.repository.BookRepository

class BookViewModel(private var bookRepository: BookRepository) : ViewModel() {

    val isBookNameEmpty = MutableLiveData<Boolean>()
    val isBookPriceEmpty = MutableLiveData<Boolean>()
    val shouldFinishActivity = MutableLiveData<Boolean>()
    var isUpdateBook = false
    var selectedCategoryId: Long? = null
    var selectedBook: BookEntity? = null
    var bookName: String? = null
    var bookPrice: String? = null

    private fun addNewBook(book: BookEntity) {
        bookRepository.insertBook(book)
    }

    private fun updateBook(book: BookEntity) {
        bookRepository.updateBook(book)
    }

    fun setBookName(charSequence: CharSequence) {
        bookName = charSequence.toString()
    }

    fun setBookPrice(charSequence: CharSequence) {
        bookPrice = charSequence.toString()
    }

    fun saveBook() {
        isBookNameEmpty.value = bookName.isNullOrEmpty()
        isBookPriceEmpty.value = bookPrice.isNullOrEmpty()

        if (!bookName.isNullOrEmpty() && !bookPrice.isNullOrEmpty()) {
            if (isUpdateBook) {
                selectedBook?.let { book ->
                    book.bookName = bookName
                    book.bookUnitPrice = bookPrice?.toDouble()
                    updateBook(book)
                }
            } else {
                val newBook = BookEntity()
                newBook.bookName = bookName
                newBook.bookUnitPrice = bookPrice?.toDouble()
                newBook.bookCategoryID = selectedCategoryId
                addNewBook(newBook)
            }
            shouldFinishActivity.value = true
        } else
            shouldFinishActivity.value = false
    }
}