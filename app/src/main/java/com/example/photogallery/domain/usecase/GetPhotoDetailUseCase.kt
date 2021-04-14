package com.example.photogallery.domain.usecase

import com.example.photogallery.domain.model.Photo
import com.example.photogallery.domain.rerository.PhotoRepository
import com.example.photogallery.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetPhotoDetailUseCase @Inject constructor(private val repository: PhotoRepository):
    SingleUseCase<Photo>() {

    private var photoId: Long? = null

    fun savePhotoId(id: Long){
        photoId = id
    }

    override fun buildUseCaseSingle(): Single<Photo> {
         return repository.getPhotoDetail(photoId)
    }

    fun deleteAsFavorite(photo: Photo){
        repository.deletePhoto(photo)
    }

    fun addAsFavorite(photo: Photo){
        repository.addPhoto(photo)
    }

    fun isFavorite(photoId: Long): Boolean{
        return repository.isFavorite(photoId)
    }
}