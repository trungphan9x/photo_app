package com.trung.photoapp.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo_detail")
data class PhotoDetailEntity(

    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "url_photo") val urlPhoto: String?,
    @ColumnInfo(name = "description") val description: String?
)