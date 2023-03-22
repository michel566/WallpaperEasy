package com.example.wallpapereasy.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.wallpapereasy.framework.db.dao.WallpaperDao
import com.example.wallpapereasy.framework.db.entity.PhotoEntity

@Database(entities = [PhotoEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun wallpapersDao(): WallpaperDao
}