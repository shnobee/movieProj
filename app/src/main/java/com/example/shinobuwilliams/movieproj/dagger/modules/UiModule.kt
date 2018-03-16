package com.example.shinobuwilliams.movieproj.dagger.modules

import com.example.shinobuwilliams.movieproj.main.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module abstract class UiModule {
    //Activity builder

    @ContributesAndroidInjector()
    abstract fun bindMainActivity(): MainActivity
}