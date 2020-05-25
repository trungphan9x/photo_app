package com.trung.photoapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.trung.photoapp.data.db.PhotoAppDatabase.Companion.DB_VERSION
import com.trung.photoapp.data.db.dao.PhotoDetailEntityDao
import com.trung.photoapp.data.db.entity.PhotoDetailEntity

@Database(entities = [PhotoDetailEntity::class], version = DB_VERSION, exportSchema = false)
abstract class PhotoAppDatabase : RoomDatabase() {
    abstract fun getPhotoDetailEntityDao(): PhotoDetailEntityDao

    companion object {
        // Singleton prevents multiple instances of database opening at the same time.
        const val DB_VERSION = 1
        private const val DB_NAME = "photo_app_database"

        @Volatile
        private var INSTANCE: PhotoAppDatabase? = null

        fun getInstance(context: Context): PhotoAppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: build(context).also { INSTANCE = it }
            }

        private fun build(context: Context) =
            Room.databaseBuilder(context.applicationContext, PhotoAppDatabase::class.java, DB_NAME)
                .addMigrations(MIGRATION_1_TO_2)
                .build()

        private val MIGRATION_1_TO_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {

            }
        }

    }
}