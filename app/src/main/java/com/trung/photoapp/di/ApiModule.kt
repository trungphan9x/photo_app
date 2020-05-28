package com.trung.photoapp.di

import com.trung.photoapp.data.remote.api.PhotoAppAPI
import org.koin.dsl.module
import retrofit2.Retrofit


val apiModule = module {
    single(createdAtStart = false) { get<Retrofit>().create(PhotoAppAPI::class.java) }
}