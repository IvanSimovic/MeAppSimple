package com.simovic.meappsimple.feature.album.domain.usecase

import com.simovic.meappsimple.base.domain.result.Result
import com.simovic.meappsimple.base.domain.result.mapSuccess
import com.simovic.meappsimple.feature.album.domain.model.Album
import com.simovic.meappsimple.feature.album.domain.repository.AlbumRepository

internal class GetAlbumListUseCase(
    private val albumRepository: AlbumRepository,
) {
    suspend operator fun invoke(query: String?): Result<List<Album>> {
        val result =
            albumRepository
                .searchAlbum(query)
                .mapSuccess {
                    val albumsWithImages = value.filter { it.getDefaultImageUrl() != null }

                    copy(value = albumsWithImages)
                }

        return result
    }
}
