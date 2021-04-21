package com.example.photogallery.presentation.album

import com.example.photogallery.domain.model.Album

interface OnAlbumsAdapterListener {

    fun showPhotos(album: Album)
}