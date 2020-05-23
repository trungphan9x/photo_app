package com.trung.photoapp.di

import com.trung.photoapp.data.PhotoRoomRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { module { PhotoRoomRepository(get()) } }
}