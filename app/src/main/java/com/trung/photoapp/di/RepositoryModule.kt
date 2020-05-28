package com.trung.photoapp.di

import com.trung.photoapp.data.repository.api.PhotoAPIRepository
import com.trung.photoapp.data.repository.room.PhotoRoomRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { PhotoRoomRepository(get()) }
    factory { PhotoAPIRepository(get()) }
}