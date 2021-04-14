package com.example.photogallery.di

import android.app.Application
import androidx.room.Room
import com.example.photogallery.data.source.local.AppDatabase
import com.example.photogallery.data.source.local.dao.PhotoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class DataBaseModule {

    @Provides
    @Singleton
    internal fun provideAppDataBase(application: Application):AppDatabase{
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            AppDatabase.DB_NAME
        ).allowMainThreadQueries().build()
    }

    @Provides
    internal fun providePhotoDao(appDatabase: AppDatabase):PhotoDao{
        return appDatabase.photoDao
    }
}