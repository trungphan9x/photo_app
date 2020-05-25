package com.trung.photoapp.util

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.trung.photoapp.R
import com.trung.photoapp.di.GlideApp

@BindingAdapter("setUrlPhoto")
fun AppCompatImageView.setUrlImage(url: String?) {
    GlideApp.with(this)
        .load(url)
        .placeholder(R.drawable.ic_default)
        .error(R.drawable.ic_default)
        .centerCrop()
        .fitCenter()
        .into(this)
}