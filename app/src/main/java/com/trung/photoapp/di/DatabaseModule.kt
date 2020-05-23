package com.trung.photoapp.di

import com.trung.photoapp.data.db.PhotoAppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val roomModule = module {
    single {
        PhotoAppDatabase.getDatabase(androidApplication())
    }

    single(createdAtStart = false) { get<PhotoAppDatabase>().getPhotoDetailEntityDao() }
}