package com.example.shinobuwilliams.movieproj.features.movies.repo

import com.example.shinobuwilliams.movieproj.features.common.RootDto
import rx.Observable
import javax.inject.Inject

class MovieRepositoryDefault @Inject constructor(
        private val dao: MovieApi.Dao
): MovieRepository {
    override fun getMovies(): Observable<RootDto> {
        return dao.getMovies()
    }

}