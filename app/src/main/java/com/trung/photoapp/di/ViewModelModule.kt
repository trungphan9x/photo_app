package com.trung.photoapp.di

import com.trung.photoapp.ui.activity.detail.DetailViewModel
import com.trung.photoapp.ui.activity.home.HomeViewModel
import com.trung.photoapp.ui.fragment.listphoto.listphoto1.ListAViewModel
import com.trung.photoapp.ui.fragment.listphoto.listphoto2.ListBViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { DetailViewModel() }
    viewModel { HomeViewModel() }
    viewModel { ListAViewModel(get(), get()) }
    viewModel { ListBViewModel(get()) }
}