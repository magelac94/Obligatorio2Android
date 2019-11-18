package com.diegomedina.notesapp.inject

import android.preference.PreferenceManager
import com.diegomedina.notesapp.data.controller.AuthController
import com.diegomedina.notesapp.data.controller.RetrofitController
import com.diegomedina.notesapp.data.helper.adapter.ZonedDateTimeAdapter
import com.diegomedina.notesapp.data.helper.networking.NetworkingManager
import com.diegomedina.notesapp.data.repository.PeliculasSourceRepository
import com.diegomedina.notesapp.data.repository.peliculas.PeliculasDataStoreFactory
import com.diegomedina.notesapp.data.service.AuthService
import com.diegomedina.notesapp.data.service.PeliculaService
import com.diegomedina.notesapp.data.source.AppDatabase
import com.diegomedina.notesapp.presentation.view.auth.LoginViewModel
import com.diegomedina.notesapp.presentation.view.home.peliculas.PeliculasViewModel
import com.example.awesomemovies.data.repository.PeliculasSourceDataRepository
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.threeten.bp.ZonedDateTime
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

var networkModule = module {
    single { NetworkingManager(get()) }
    single<GsonConverterFactory> {
        GsonConverterFactory.create(
            GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(ZonedDateTime::class.java, ZonedDateTimeAdapter())
                .create()
        )
    }

    single { RetrofitController(get()) }
    single<Retrofit> { get<RetrofitController>().initRetrofit() }
    single<PeliculaService> { get<Retrofit>().create(PeliculaService::class.java) }
    single<AuthService> { get<Retrofit>().create(AuthService::class.java) }
}

var databaseModule = module {
    single { AppDatabase.getInstance(get()).peliculaDao() }
}

var peliculasModule = module {
    single { PeliculasDataStoreFactory(get(), get(), get()) }
    single<PeliculasSourceRepository> { PeliculasSourceDataRepository(get()) }

    viewModel { PeliculasViewModel(get()) }
}

var loginModule = module {
    single { AuthController(get(), get(), get()) }
    single { PreferenceManager.getDefaultSharedPreferences(get()) }

    viewModel { LoginViewModel(get()) }
}
