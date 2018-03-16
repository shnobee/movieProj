package com.example.shinobuwilliams.movieproj.main.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.shinobuwilliams.movieproj.R
import com.example.shinobuwilliams.movieproj.main.logic.MainPresenterDefault
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject lateinit var presenter: MainPresenterDefault

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)

        test.setOnClickListener { _ ->
            presenter.buttonPressed()}
    }
}
