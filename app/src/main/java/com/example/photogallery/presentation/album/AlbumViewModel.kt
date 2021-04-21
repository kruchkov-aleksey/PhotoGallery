package com.example.photogallery.presentation.album

import androidx.lifecycle.MutableLiveData
import com.example.photogallery.domain.model.Album

class AlbumViewModel(val album: Album) {

    val albumData = MutableLiveData<Album>()

    init {
        albumData.value = album
    }
}