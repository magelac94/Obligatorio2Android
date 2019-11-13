package com.diegomedina.notesapp.data.controller

import com.diegomedina.notesapp.App
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

class RetrofitController(
    private val gsonConverterFactory: GsonConverterFactory
) {
    var accessToken: String? = "b047fda6c17df2280f374f88f849cbce"

    fun initRetrofit() =
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(gsonConverterFactory)
            .client(httpClient)
            .build()


    private val httpClient
        get() = OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .addInterceptor { chain ->
                val response = chain.proceed(chain.request())

                if (response.code == HttpURLConnection.HTTP_UNAUTHORIZED && accessToken != null) {
                    App.goToLoginScreen()
                }

                response
            }
            .addInterceptor { chain ->
                if (accessToken != null) {
                    val request = chain.request()
                        .newBuilder()
                        .addHeader("Authorization", accessToken ?: "")
                        .build()

                    chain.proceed(request)
                } else {
                    chain.proceed(chain.request())
                }
            }
            .build()
}
