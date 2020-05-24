package com.trung.photoapp.ui.fragment.listphoto.listphoto2

import androidx.lifecycle.LiveData
import com.trung.photoapp.core.BaseViewModel
import com.trung.photoapp.data.PhotoRoomRepository
import com.trung.photoapp.data.db.entity.PhotoDetailEntity

class ListBViewModel(private val photoRoomRepository: PhotoRoomRepository) : BaseViewModel() {
    var allPhoto: LiveData<List<PhotoDetailEntity>> = photoRoomRepository.allAscendedPhoto
}