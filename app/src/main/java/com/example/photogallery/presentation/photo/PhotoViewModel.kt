package com.example.photogallery.presentation.photo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.photogallery.domain.model.Photo

class PhotoViewModel(val photo: Photo): ViewModel() {

    val photoData = MutableLiveData<Photo>()

    init{
        photoData.value = photo
    }
}