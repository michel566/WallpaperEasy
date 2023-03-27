package com.example.wallpapereasy.framework.db.dao

import androidx.room.*
import com.example.core.data.DBConstants
import com.example.core.model.PhotoDomain
import com.example.wallpapereasy.framework.db.entity.PhotoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WallpaperDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: PhotoEntity)

    @Query("SELECT * FROM ${DBConstants.PHOTO_TABLE_NAME}")
    fun getAllPhotos(): Flow<List<PhotoEntity>>

    @Delete()
    suspend fun delete(entity: PhotoEntity)

}