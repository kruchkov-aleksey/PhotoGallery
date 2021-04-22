package com.example.photogallery.presentation.photo

import android.widget.ImageView

interface OnPhotosAdapterListener {

    fun gotoDetailPage(imageView: ImageView, id: Long)

}