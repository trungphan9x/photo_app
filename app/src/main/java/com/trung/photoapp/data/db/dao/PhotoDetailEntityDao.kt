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
    fun getAlphabetizedWords(): LiveData<List<PhotoDetailEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: PhotoDetailEntity)

    @Query("DELETE FROM photo_detail")
    suspend fun deleteAll()
}