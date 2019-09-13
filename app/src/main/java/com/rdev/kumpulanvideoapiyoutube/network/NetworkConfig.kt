package com.rdev.kumpulanvideoapiyoutube.network

import com.rdev.kumpulanvideoapiyoutube.data.ResultVideo
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object NetworkConfig {
    fun getInterceptor(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return client
    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/youtube/v3/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun service() = getRetrofit().create(YoutubeService::class.java)
}

interface YoutubeService {
    @GET("search?")
    fun getVideo(@Query("part") part : String,
                 @Query("q") q : String,
                 @Query("key") key : String) : Call<ResultVideo>
}
