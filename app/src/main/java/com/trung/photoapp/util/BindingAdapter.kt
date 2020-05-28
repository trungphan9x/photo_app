package com.trung.photoapp.util

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.trung.photoapp.R
import com.trung.photoapp.data.db.entity.PhotoDetailEntity
import com.trung.photoapp.di.GlideApp
import com.trung.photoapp.ui.fragment.listphoto.ListPhotoAdapterWithDiffCallback

@BindingAdapter("setUrlPhoto")
fun AppCompatImageView.setUrlImage(url: String?) {
    GlideApp.with(this.context)
        .load(url)
        .placeholder(R.drawable.ic_default)
        .error(R.drawable.bg_error_image)
        .centerCrop()
        .fitCenter()
        .into(this)
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<PhotoDetailEntity>?) {
    val adapter = recyclerView.adapter as ListPhotoAdapterWithDiffCallback
    //adapter.submitList(data)
    adapter.setIetms(data)
}