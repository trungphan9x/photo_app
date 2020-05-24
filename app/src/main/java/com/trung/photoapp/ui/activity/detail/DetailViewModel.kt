package com.trung.photoapp.ui.activity.detail

import androidx.databinding.ObservableField
import com.trung.photoapp.core.BaseViewModel

class DetailViewModel : BaseViewModel() {
    val detailPhotoName = ObservableField<String>()
    val detailPhotoUrl = ObservableField<String>()
    val detailPhotoDescription = ObservableField<String>()
}