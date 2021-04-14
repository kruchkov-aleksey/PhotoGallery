package com.example.photogallery.data.repository

import com.example.photogallery.data.source.remote.RetrofitService
import com.example.photogallery.domain.model.Album
import com.example.photogallery.domain.rerository.AlbumRepository
import io.reactivex.Single

class AlbumRepositoryImp(private val retrofitService: RetrofitService):AlbumRepository {
    override fun getAlbums(): Single<List<Album>> {
        return retrofitService.getAlbums()
    }

}