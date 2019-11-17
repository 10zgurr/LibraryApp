package com.sample.libraryapplication.dagger.components

import com.sample.libraryapplication.dagger.modules.AppModule
import com.sample.libraryapplication.dagger.modules.LibraryModule
import com.sample.libraryapplication.view.BookActivity
import com.sample.libraryapplication.view.BookListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, LibraryModule::class])
interface LibraryComponent {
    fun inject(bookActivity: BookActivity)
    fun inject(bookListActivity: BookListActivity)
}