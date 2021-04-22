package com.example.photogallery.presentation.gallery

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.photogallery.R
import com.example.photogallery.domain.model.Album
import com.example.photogallery.presentation.album.AlbumsFragment
import com.example.photogallery.presentation.photo.PhotosFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryActivity : AppCompatActivity(), OnGalleryCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        if(savedInstanceState == null){
            navigateToGalleryPage()
        }
    }

    private fun navigateToGalleryPage(){
        supportFragmentManager.beginTransaction()
                .replace(
                        R.id.gallery_container,
                        AlbumsFragment.newInstance(),
                        AlbumsFragment.FRAGMENT_NAME
                ).commitAllowingStateLoss()
    }

    override fun navigateToAlbumPage(album: Album) {
        supportFragmentManager.beginTransaction()
                .replace(
                        R.id.gallery_container,
                        PhotosFragment.newInstance(album.id),
                        PhotosFragment.FRAGMENT_NAME
                )
                .addToBackStack(PhotosFragment.FRAGMENT_NAME)
                .commitAllowingStateLoss()
    }

    override fun gotoDetailPageByPhotoId(imageView: ImageView, id: Long) {
        TODO("Not yet implemented")
    }


}