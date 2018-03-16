package com.example.shinobuwilliams.movieproj.dagger.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module class AppModule {
    @Provides @Singleton fun provideContext(application: Application): Context = application.applicationContext

    @Provides @Singleton fun provideApplication(application: Application): Application = application
}