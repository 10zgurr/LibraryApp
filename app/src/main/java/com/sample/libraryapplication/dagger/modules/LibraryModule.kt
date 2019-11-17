package com.sample.libraryapplication.dagger.modules

import android.app.Application
import com.sample.libraryapplication.repository.BookRepository
import com.sample.libraryapplication.repository.CategoryRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LibraryModule {

    @Singleton
    @Provides
    fun providesBookRepository(application: Application): BookRepository {
        return BookRepository(application)
    }

    @Singleton
    @Provides
    fun providesCategoryRepository(application: Application): CategoryRepository {
        return CategoryRepository(application)
    }
}