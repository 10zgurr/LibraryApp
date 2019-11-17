package com.sample.libraryapplication.dagger.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(application: Application) {

    private var libraryApplication = application

    @Singleton
    @Provides
    fun providesApplication(): Application {
        return libraryApplication
    }
}