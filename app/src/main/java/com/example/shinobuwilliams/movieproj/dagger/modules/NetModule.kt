package com.example.shinobuwilliams.movieproj.dagger.modules

import android.app.Application
import com.example.shinobuwilliams.movieproj.features.common.Util.addLoggingInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
abstract class NetModule {
    @Module companion object {
        @Provides
        @Singleton
        @JvmStatic
        fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
//        .create(className)
        }

        @Provides
        @Singleton
        @JvmStatic
        fun provideOkHttpClient(cache: Cache): OkHttpClient {
            val builder = OkHttpClient.Builder().cache(cache). apply {
                addInterceptor({chain ->
                    val originalRequest = chain.request()
                    val originalUrl = originalRequest.url()

                    val transformedUrl = originalUrl.newBuilder()
                       .addQueryParameter("api_key", "652d8456e7b20bf2d9694392adad3a74")
                       .build()
                    val requestBuilder = originalRequest.newBuilder().url(transformedUrl)
               chain.proceed(requestBuilder.build()) })
                addLoggingInterceptor()
            }
            return builder.build()
        }

        @Provides
        @Singleton
        @JvmStatic
        fun provideCache(application: Application): Cache {
            val cacheSize: Long = 10 * 1024 * 1024 //10MiB
            return Cache(application.cacheDir, cacheSize)
        }

    }
//    @Provides @Singleton fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
//        return Retrofit.Builder()
//                .client(okHttpClient)
//                .baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build()
//        //.create(className)
//    }
//
//    @Provides fun provideOkHttpClient(cache: Cache): OkHttpClient {
//       val builder = OkHttpClient.Builder().cache(cache). apply {
//
//           addInterceptor({chain ->
//               val originalRequest = chain.request()
//               val originalUrl = originalRequest.url()
//
//               val transformedUrl = originalUrl.newBuilder()
//                       .addQueryParameter("api_key", "652d8456e7b20bf2d9694392adad3a74")
//                       .build()
//
//               val requestBuilder = originalRequest.newBuilder().url(transformedUrl)
//               chain.proceed(requestBuilder.build())
//           })
//
//           addLoggingInterceptor()
//       }
//        return builder.build()
//    }
//
//    @Provides fun provideCache(application: Application): Cache {
//        val cacheSize: Long = 10 * 1024 * 1024 //10MiB
//        return Cache(application.cacheDir, cacheSize)
//    }
}