package com.sample.libraryapplication

import android.app.Application

class LibraryApplication : Application() {

    companion object {
        lateinit var instance: LibraryApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}