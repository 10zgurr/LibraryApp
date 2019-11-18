package com.sample.libraryapplication.dagger.module

import com.sample.libraryapplication.database.LibraryDatabase
import com.sample.libraryapplication.repository.BookRepository
import com.sample.libraryapplication.repository.CategoryRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LibraryModule {

    @Singleton
    @Provides
    fun providesBookRepository(libraryDatabase: LibraryDatabase): BookRepository {
        return BookRepository(libraryDatabase)
    }

    @Singleton
    @Provides
    fun providesCategoryRepository(libraryDatabase: LibraryDatabase): CategoryRepository {
        return CategoryRepository(libraryDatabase)
    }
}