package com.simovic.meappsimple.feature.album.domain.usecase

import com.simovic.meappsimple.base.domain.result.Result
import com.simovic.meappsimple.feature.album.domain.repository.AlbumRepository

internal class ToggleAlbumFavoriteStatusUseCase(
    private val albumRepository: AlbumRepository,
) {
    suspend operator fun invoke(
        albumMbId: String,
        isFavorite: Boolean,
    ): Result<Unit> =
        if (isFavorite) {
            albumRepository.removeAlbumFromFavorites(albumMbId)
        } else {
            albumRepository.addAlbumToFavorites(albumMbId)
        }
}
