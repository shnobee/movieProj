package com.example.shinobuwilliams.movieproj.features.movies.interactor

import com.example.shinobuwilliams.movieproj.features.common.RootDto
import com.example.shinobuwilliams.movieproj.features.movies.repo.MovieRepository
import rx.Observable
import javax.inject.Inject

class MovieInteractorDefault @Inject constructor(
        private val repository: MovieRepository
): MovieInteractor {
    override fun getMovies(): Observable<RootDto> {
        return repository.getMovies()
    }

}