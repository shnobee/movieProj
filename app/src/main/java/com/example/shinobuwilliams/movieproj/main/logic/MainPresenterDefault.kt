package com.example.shinobuwilliams.movieproj.main.logic

import com.example.shinobuwilliams.movieproj.features.movies.interactor.MovieInteractor
import javax.inject.Inject

class MainPresenterDefault @Inject constructor (
private val interactor: MovieInteractor
): MainPresenter {
    override fun buttonPressed() {
        interactor.getMovies()
    }
}