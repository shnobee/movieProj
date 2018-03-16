package com.example.shinobuwilliams.movieproj.dagger.modules

import com.example.shinobuwilliams.movieproj.main.logic.MainPresenter
import com.example.shinobuwilliams.movieproj.main.logic.MainPresenterDefault
import dagger.Binds
import dagger.Module

@Module
abstract class MainModule {
    @Binds
    abstract fun provideMainPresenter(presenterDefault: MainPresenterDefault): MainPresenter
}
