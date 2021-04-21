package com.example.photogallery.presentation.album

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.photogallery.domain.model.Album
import com.example.photogallery.domain.usecase.GetAlbumsUseCase

class AlbumsViewModel @ViewModelInject constructor(private val getAlbumsUseCase: GetAlbumsUseCase): ViewModel() {

    val albumsReceivedLiveData = MutableLiveData<List<Album>>()
    val isLoad = MutableLiveData<Boolean>()
    val albumData = MutableLiveData<Album>()

    init {
        isLoad.value = false
    }

    val album: Album? get() = albumData.value

    fun set(album: Album) = run{albumData.value = album}

    fun loadAlbums(){
        getAlbumsUseCase.execute(
            onSuccess = {
                isLoad.value = true
                albumsReceivedLiveData.value = it
            },
            onError = {
                it.printStackTrace()
            }
        )
    }
}