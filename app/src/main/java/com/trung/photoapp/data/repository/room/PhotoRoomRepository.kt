package com.trung.photoapp.data.repository.room

import androidx.lifecycle.LiveData
import com.trung.photoapp.data.db.dao.PhotoDetailEntityDao
import com.trung.photoapp.data.db.entity.PhotoDetailEntity
import com.trung.photoapp.data.remote.response.PhotoDetail

class PhotoRoomRepository(private val photoDetailEntityDao: PhotoDetailEntityDao) {
    val allAlphabetizedPhoto: LiveData<List<PhotoDetailEntity>> =
        photoDetailEntityDao.getAlphabetizedPhotos()

    val allAscendedPhoto: LiveData<List<PhotoDetailEntity>> =
        photoDetailEntityDao.getAscendedPhotos()

    suspend fun insert(photo: PhotoDetail) =
        photoDetailEntityDao.insert(
            PhotoDetailEntity(
                id = photo.id,
                name = photo.name,
                urlPhoto = photo.urlPhoto,
                description = photo.description
            )
        )

    suspend fun insertAll(listPhoto: List<PhotoDetail>) {
        val listPhotoDetailEntity = ArrayList<PhotoDetailEntity>()
        listPhoto.forEach {
            listPhotoDetailEntity.add(
                PhotoDetailEntity(
                    id = it.id,
                    name = it.name,
                    urlPhoto = it.urlPhoto,
                    description = it.description
                )
            )
        }
        return photoDetailEntityDao.insertAll(listPhotoDetailEntity)
    }

}