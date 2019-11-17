package com.sample.libraryapplication

import android.app.Application
import com.sample.libraryapplication.dagger.components.DaggerLibraryComponent
import com.sample.libraryapplication.dagger.components.LibraryComponent
import com.sample.libraryapplication.dagger.modules.AppModule

class LibraryApplication : Application() {

    companion object {
        lateinit var instance: LibraryApplication
    }
    lateinit var libraryComponent: LibraryComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        libraryComponent = DaggerLibraryComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }
}