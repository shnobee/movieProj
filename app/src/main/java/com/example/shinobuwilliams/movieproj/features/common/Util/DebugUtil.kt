package com.example.shinobuwilliams.movieproj.features.common.Util

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

fun OkHttpClient.Builder.addLoggingInterceptor() {
    //stetho interceptor

    //REST logging
    val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    this.addNetworkInterceptor(httpLoggingInterceptor)
}