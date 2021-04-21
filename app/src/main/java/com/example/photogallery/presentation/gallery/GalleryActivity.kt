package com.example.photogallery.presentation.gallery

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.photogallery.R
import com.example.photogallery.domain.model.Album
import com.example.photogallery.presentation.album.AlbumsFragment
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

    override fun navigateToAlbumPage(album: Album) {
        TODO("Not yet implemented")
    }
    private fun navigateToGalleryPage(){
        supportFragmentManager.beginTransaction()
                .replace(
                        R.id.gallery_container,
                        AlbumsFragment.newInstance(),
                        AlbumsFragment.FRAGMENT_NAME,
                ).commitAllowingStateLoss()
    }

    override fun gotoDetailPageByPhotoId(imageView: ImageView, id: Long) {
        TODO("Not yet implemented")
    }


}