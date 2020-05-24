package com.trung.photoapp.ui.activity.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.trung.photoapp.R
import com.trung.photoapp.core.BaseActivity
import com.trung.photoapp.data.db.entity.PhotoDetailEntity
import com.trung.photoapp.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : BaseActivity<ActivityDetailBinding>() {
    private val viewModel by viewModel(DetailViewModel::class)
    override fun getLayoutResId() = R.layout.activity_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.vm = viewModel

        intent?.let {
            viewModel.detailPhotoName.set(intent.getStringExtra(DETAIL_PHOTO_NAME))
            viewModel.detailPhotoUrl.set(intent.getStringExtra(DETAIL_PHOTO_URL))
            viewModel.detailPhotoDescription.set(intent.getStringExtra(DETAIL_PHOTO_DESCRIPTION))
        }
    }


    companion object {
        private const val DETAIL_PHOTO_NAME = "detail_photo_name"
        private const val DETAIL_PHOTO_URL = "detail_photo_url"
        private const val DETAIL_PHOTO_DESCRIPTION = "detail_photo_description"

        fun startActivity(activity: Activity?, detailPhoto: PhotoDetailEntity) {
            Intent(activity, DetailActivity::class.java).apply {
                this.putExtra(DETAIL_PHOTO_NAME, detailPhoto.name)
                this.putExtra(DETAIL_PHOTO_URL, detailPhoto.urlPhoto)
                this.putExtra(DETAIL_PHOTO_DESCRIPTION, detailPhoto.description)
            }.also {
                activity?.startActivity(it)
            }
        }
    }
}