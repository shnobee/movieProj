package com.example.shinobuwilliams.movieproj.features.movies

import com.example.shinobuwilliams.movieproj.features.movies.interactor.MovieInteractor
import com.example.shinobuwilliams.movieproj.features.movies.interactor.MovieInteractorDefault
import com.example.shinobuwilliams.movieproj.features.movies.repo.MovieApi
import com.example.shinobuwilliams.movieproj.features.movies.repo.MovieRepository
import com.example.shinobuwilliams.movieproj.features.movies.repo.MovieRepositoryDefault
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module abstract class MoviesModule {
    @Binds
    @Singleton
    abstract fun moviRepo(repository: MovieRepositoryDefault): MovieRepository

    @Binds
    @Singleton
    abstract fun movieInteractor(interactor: MovieInteractorDefault): MovieInteractor

    @Module companion object {
        @Provides
        @Singleton @JvmStatic
        fun dao(retrofit: Retrofit): MovieApi.Dao {
            return retrofit.create(MovieApi.Dao::class.java)
        }
    }
}