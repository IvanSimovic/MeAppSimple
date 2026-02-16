package com.simovic.meappsimple.feature.album.domain.usecase

import com.simovic.meappsimple.base.domain.result.Result
import com.simovic.meappsimple.feature.album.domain.model.Album
import com.simovic.meappsimple.feature.album.domain.repository.AlbumRepository

internal class GetAlbumUseCase(
    private val albumRepository: AlbumRepository,
) {
    suspend operator fun invoke(
        artistName: String,
        albumName: String,
        mbId: String?,
    ): Result<Album> = albumRepository.getAlbumInfo(artistName, albumName, mbId)
}
