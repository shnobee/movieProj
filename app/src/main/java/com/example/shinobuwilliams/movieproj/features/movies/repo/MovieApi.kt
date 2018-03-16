package com.example.shinobuwilliams.movieproj.features.movies.repo

import com.example.shinobuwilliams.movieproj.features.common.RootDto
import retrofit2.http.GET
import rx.Observable

class MovieApi {
    interface Dao {
        @GET("discovery/movie") fun getMovies(): Observable<RootDto>
    }
}