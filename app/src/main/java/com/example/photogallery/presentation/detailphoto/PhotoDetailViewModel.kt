package com.example.photogallery.presentation.detailphoto

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.photogallery.domain.model.Photo
import com.example.photogallery.domain.usecase.GetPhotoDetailUseCase

class PhotoDetailViewModel @ViewModelInject constructor(private val getPhotoDetailUseCase: GetPhotoDetailUseCase) : ViewModel() {

    val photoData = MutableLiveData<Photo>()
    val isLoad = MutableLiveData<Boolean>()
    val isFavorite = MutableLiveData<Boolean>()

    init {
        isLoad.value = false
    }

    fun getDetail(id: Long?){
        if (id == null) return
        getPhotoDetailUseCase.savePhotoId(id)
        getPhotoDetailUseCase.execute(
                onSuccess = {
                    isLoad.value = true
                    photoData.value = it
                },
                onError = {
                    it.printStackTrace()
                }
        )
    }

    fun updateFavoriteStatus(){
        photoData.value?.let { photo ->
            if(isFavorite.value == true){
                getPhotoDetailUseCase.deleteAsFavorite(photo)
            }else{
                getPhotoDetailUseCase.addAsFavorite(photo)
            }
            isFavorite.value?.let{
                isFavorite.value = !it
            }
        }
    }

    fun checkFavoriteStatus(photoId: Long){
        isFavorite.value = getPhotoDetailUseCase.isFavorite(photoId)
    }
}