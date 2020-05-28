package com.trung.photoapp.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    single { buildRetrofit() }
}

fun buildRetrofit(): Retrofit {
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    return Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl("https://testproject-f8281.web.app/sen/")
        .build()
}
