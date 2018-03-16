package com.example.shinobuwilliams.movieproj.features.movies.repo

import com.example.shinobuwilliams.movieproj.features.common.RootDto
import rx.Observable

interface MovieRepository {
    fun getMovies(): Observable<RootDto>
}