package com.example.photogallery.domain.rerository

import com.example.photogallery.domain.model.Photo
import io.reactivex.Single

interface PhotoRepository {

    fun getPhotos(albumId: Long?): Single<List<Photo>>

    fun getPhotoDetail(photoId: Long?): Single<Photo>

    fun deletePhoto(photo: Photo)

    fun addPhoto(photo: Photo)

    fun isFavorite(photoId: Long): Boolean
}