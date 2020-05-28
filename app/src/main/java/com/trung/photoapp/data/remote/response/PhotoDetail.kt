package com.trung.photoapp.data.remote.response

import com.squareup.moshi.Json

data class PhotoDetail(
    val id: Int,
    @Json(name = "name_photo") val name: String?,
    @Json(name = "url_photo") val urlPhoto: String?,
    @Json(name = "description_photo") val description: String?
)