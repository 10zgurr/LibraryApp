package com.sample.libraryapplication.dagger.component

import com.sample.libraryapplication.dagger.module.LibraryModule
import com.sample.libraryapplication.dagger.module.RoomDatabaseModule
import com.sample.libraryapplication.view.BookActivity
import com.sample.libraryapplication.view.BookListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RoomDatabaseModule::class, LibraryModule::class])
interface LibraryComponent {
    fun inject(bookActivity: BookActivity)
    fun inject(bookListActivity: BookListActivity)
}