package com.sample.libraryapplication.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.sample.libraryapplication.database.dao.BookDAO
import com.sample.libraryapplication.database.dao.CategoryDAO
import com.sample.libraryapplication.database.entity.BookEntity
import com.sample.libraryapplication.database.entity.CategoryEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [CategoryEntity::class, BookEntity::class], version = 1)
abstract class LibraryDatabase : RoomDatabase() {

    abstract fun getCategoryDAO(): CategoryDAO
    abstract fun getBookDAO(): BookDAO

    companion object {

        private const val EDUCATIONAL_BOOKS_CATEGORY_ID = 1L
        private const val NOVELS_CATEGORY_ID = 2L
        private const val OTHER_BOOKS_CATEGORY_ID = 3L

        private val databaseCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                CoroutineScope(Dispatchers.IO).launch {
                    addSampleBooksToDatabase()
                }
            }
        }

        private fun addSampleBooksToDatabase() {
            val category1 = CategoryEntity(EDUCATIONAL_BOOKS_CATEGORY_ID, "Educational Books", "Educational Books Desc")
            val category2 = CategoryEntity(NOVELS_CATEGORY_ID, "Novels", "Novels Desc")
            val category3 = CategoryEntity(OTHER_BOOKS_CATEGORY_ID, "Other Books", "Non Categorized Books")

            val book1 = BookEntity(1, "Java Programming Book", 10.50, EDUCATIONAL_BOOKS_CATEGORY_ID)
            val book2 = BookEntity(2, "Mathematics", 19.10, EDUCATIONAL_BOOKS_CATEGORY_ID)
            val book3 = BookEntity(3, "Adventures of Joe Finn", 25.30, NOVELS_CATEGORY_ID)
            val book4 = BookEntity(4, "The Hound the New York", 5.30, NOVELS_CATEGORY_ID)
            val book5 = BookEntity(5, "Astrology", 56.99, OTHER_BOOKS_CATEGORY_ID)
            val book6 = BookEntity(6, "Arc of Witches", 34.99, OTHER_BOOKS_CATEGORY_ID)
            val book7 = BookEntity(7, "Can I Run?", 99.99, NOVELS_CATEGORY_ID)
            val book8 = BookEntity(8, "Basic of Physics", 10.50, EDUCATIONAL_BOOKS_CATEGORY_ID)

            val categoryDAO = getInstance(libraryApplication).getCategoryDAO()
            categoryDAO.addCategory(category1)
            categoryDAO.addCategory(category2)
            categoryDAO.addCategory(category3)

            val bookDAO = getInstance(libraryApplication).getBookDAO()
            bookDAO.addBook(book1)
            bookDAO.addBook(book2)
            bookDAO.addBook(book3)
            bookDAO.addBook(book4)
            bookDAO.addBook(book5)
            bookDAO.addBook(book6)
            bookDAO.addBook(book7)
            bookDAO.addBook(book8)
        }

        private lateinit var libraryApplication: Application

        private var instance: LibraryDatabase? = null
        fun getInstance(application: Application): LibraryDatabase {
            libraryApplication = application
            return if (instance == null) synchronized(this) {
                instance = Room.databaseBuilder(application, LibraryDatabase::class.java, "library_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(databaseCallback)
                    .build()
                instance!!
            } else
                instance!!
        }
    }
}