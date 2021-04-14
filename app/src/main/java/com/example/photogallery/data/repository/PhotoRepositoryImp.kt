package com.example.photogallery.data.repository

import com.example.photogallery.data.source.local.AppDatabase
import com.example.photogallery.data.source.remote.RetrofitService
import com.example.photogallery.domain.model.Photo
import com.example.photogallery.domain.rerository.PhotoRepository
import io.reactivex.Single

class PhotoRepositoryImp(private val database: AppDatabase,
                         private val retrofitService: RetrofitService):PhotoRepository {

    override fun getPhotos(albumId: Long?): Single<List<Photo>> {
        return retrofitService.getPhotos(albumId!!)
    }

    override fun getPhotoDetail(photoId: Long?): Single<Photo> {
        return  retrofitService.getPhotoDetail(photoId!!)
    }

    override fun deletePhoto(photo: Photo) {
        database.photoDao.delete(photo)
    }

    override fun addPhoto(photo: Photo) {
        database.photoDao.insert(photo)
    }

    override fun isFavorite(photoId: Long): Boolean {
        val loadOneByPhotoId =database.photoDao.loadOneByPhotoId(photoId)
        return loadOneByPhotoId != null
    }
}