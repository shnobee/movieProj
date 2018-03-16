package com.example.shinobuwilliams.movieproj.features.movies.interactor

import com.example.shinobuwilliams.movieproj.features.common.RootDto
import rx.Observable

interface MovieInteractor {
     fun getMovies(): Observable<RootDto>
}