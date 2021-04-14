package com.example.photogallery.domain.usecase

import com.example.photogallery.domain.model.Album
import com.example.photogallery.domain.rerository.AlbumRepository
import com.example.photogallery.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetAlbumsUseCase @Inject constructor(private val repository: AlbumRepository):
    SingleUseCase<List<Album>>() {

    override fun buildUseCaseSingle(): Single<List<Album>> {
        return repository.getAlbums()
    }
}