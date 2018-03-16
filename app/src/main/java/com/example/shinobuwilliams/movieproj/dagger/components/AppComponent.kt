package com.example.shinobuwilliams.movieproj.dagger.components

import android.app.Application
import com.example.shinobuwilliams.movieproj.dagger.modules.AppModule
import com.example.shinobuwilliams.movieproj.dagger.modules.MainModule
import com.example.shinobuwilliams.movieproj.dagger.modules.NetModule
import com.example.shinobuwilliams.movieproj.dagger.modules.UiModule
import com.example.shinobuwilliams.movieproj.features.movies.MoviesModule
import com.example.shinobuwilliams.movieproj.main.ui.MovieProjApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    UiModule::class,
    AndroidSupportInjectionModule::class,
    MainModule::class,
    MoviesModule::class,
    NetModule::class
])
interface AppComponent {
    @Component.Builder
    interface Builder {
        //Don't need to specify this anymore as dagger will use the default constructor of AppModule now
        //fun appModule(appModule: AppModule): Builder

        //constructor parameter for app module
        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun baseUrl(baseUrl: String): Builder

        fun build(): AppComponent
    }

    fun inject(app: MovieProjApplication)
}