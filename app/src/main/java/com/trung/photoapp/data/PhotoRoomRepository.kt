package com.trung.photoapp.data

import androidx.lifecycle.LiveData
import com.trung.photoapp.data.db.dao.PhotoDetailEntityDao
import com.trung.photoapp.data.db.entity.PhotoDetailEntity

class PhotoRoomRepository(private val photoDetailEntityDao: PhotoDetailEntityDao) {
    val allAlphabetizedPhoto: LiveData<List<PhotoDetailEntity>> =
        photoDetailEntityDao.getAlphabetizedPhotos()

    val allAscendedPhoto: LiveData<List<PhotoDetailEntity>> =
        photoDetailEntityDao.getAscendedPhotos()

    suspend fun insert(photo: PhotoDetailEntity) =
        photoDetailEntityDao.insert(photo)

    suspend fun insertAll(listPhoto: List<PhotoDetailEntity>) =
        photoDetailEntityDao.insertAll(listPhoto)
}