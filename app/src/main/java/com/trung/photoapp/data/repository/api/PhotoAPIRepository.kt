package com.trung.photoapp.data.repository.api

import com.trung.photoapp.data.remote.PhotoAppResponseBody
import com.trung.photoapp.data.remote.api.PhotoAppAPI
import com.trung.photoapp.data.remote.response.PhotoDetail

class PhotoAPIRepository(private val photoAppAPI: PhotoAppAPI) {

    suspend fun getPhotoDetailFromApi(): PhotoAppResponseBody<List<PhotoDetail>> {
        return photoAppAPI.getPhotoDetail()
    }
}