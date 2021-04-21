package com.example.photogallery.presentation.gallery

import android.widget.ImageView
import com.example.photogallery.domain.model.Album

interface OnGalleryCallback {

    fun navigateToAlbumPage(album: Album)

    fun gotoDetailPageByPhotoId(imageView: ImageView, id: Long)
}