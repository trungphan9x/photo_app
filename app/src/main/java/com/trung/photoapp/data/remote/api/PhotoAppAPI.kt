package com.trung.photoapp.data.remote.api

import com.trung.photoapp.data.remote.PhotoAppResponseBody
import com.trung.photoapp.data.remote.response.PhotoDetail
import retrofit2.http.GET

interface PhotoAppAPI {
    @GET("appdr_json.json")
    suspend fun getPhotoDetail(): PhotoAppResponseBody<List<PhotoDetail>>
}