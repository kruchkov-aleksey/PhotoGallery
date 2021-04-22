package com.example.photogallery.presentation.photo

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.photogallery.domain.model.Photo
import com.example.photogallery.domain.usecase.GetPhotosUseCase

class PhotosViewModel @ViewModelInject constructor(private val getPhotosUseCase: GetPhotosUseCase): ViewModel() {

    val photoListRecievedLiveData =MutableLiveData<List<Photo>>()
    val isLoad = MutableLiveData<Boolean>()

    init {
        isLoad.value = false
    }

    fun loadPhotos(id: Long?){
        if(id == null) return
        getPhotosUseCase.saveAlbumId(id)
        getPhotosUseCase.execute(
            onSuccess = {
                isLoad.value = true
                photoListRecievedLiveData.value = it
            },
                onError = {
                    it.printStackTrace()
                }
        )
    }
}