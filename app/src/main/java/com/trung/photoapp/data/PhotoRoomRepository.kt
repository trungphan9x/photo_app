package com.trung.photoapp.data

import androidx.lifecycle.LiveData
import com.trung.photoapp.data.db.dao.PhotoDetailEntityDao
import com.trung.photoapp.data.db.entity.PhotoDetailEntity

class PhotoRoomRepository(private val photoDetailEntityDao: PhotoDetailEntityDao) {
    val allPhoto: LiveData<List<PhotoDetailEntity>> = photoDetailEntityDao.getAlphabetizedWords()

    suspend fun insert(photoDetailEntity: PhotoDetailEntity) =
        photoDetailEntityDao.insert(photoDetailEntity)
}