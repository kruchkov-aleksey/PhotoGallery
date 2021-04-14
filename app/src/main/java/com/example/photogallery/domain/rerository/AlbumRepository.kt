package com.example.photogallery.domain.rerository

import com.example.photogallery.domain.model.Album
import io.reactivex.Single

interface AlbumRepository {

    fun getAlbums(): Single<List<Album>>
}