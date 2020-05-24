package com.trung.photoapp.util

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.trung.photoapp.R

@BindingAdapter("setUrlPhoto")
fun AppCompatImageView.setUrlImage(url: String?) {
    Glide.with(this)
        .load(url)
        .placeholder(R.drawable.ic_default)
        .error(R.drawable.ic_default)
        .centerCrop()
        .fitCenter()
        .into(this)
}