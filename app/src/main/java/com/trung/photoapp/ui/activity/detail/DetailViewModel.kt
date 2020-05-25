package com.trung.photoapp.ui.activity.detail

import android.view.View
import androidx.databinding.ObservableField
import com.trung.photoapp.core.BaseViewModel

class DetailViewModel : BaseViewModel() {

    var detailView: DetailActivity? = null

    val detailPhotoName = ObservableField<String>()
    val detailPhotoUrl = ObservableField<String>()
    val detailPhotoDescription = ObservableField<String>()

    fun onClickBack(view: View) {
        detailView?.onBackPressed()
    }
}