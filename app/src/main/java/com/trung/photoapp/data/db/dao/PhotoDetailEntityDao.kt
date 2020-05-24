package com.trung.photoapp.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.trung.photoapp.data.db.entity.PhotoDetailEntity

@Dao
interface PhotoDetailEntityDao {

    @Query("SELECT * from photo_detail ORDER BY name ASC")
    fun getAlphabetizedPhotos(): LiveData<List<PhotoDetailEntity>>

    @Query("SELECT * from photo_detail ORDER BY id ASC")
    fun getAscendedPhotos(): LiveData<List<PhotoDetailEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(photo: PhotoDetailEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(listPhoto: List<PhotoDetailEntity>)

    @Query("DELETE FROM photo_detail")
    suspend fun deleteAll()
}