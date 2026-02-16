package com.simovic.meappsimple.feature.album.domain.repository

import com.simovic.meappsimple.base.domain.result.Result
import com.simovic.meappsimple.feature.album.domain.model.Album

internal interface AlbumRepository {
    suspend fun getAlbumInfo(
        artistName: String,
        albumName: String,
        mbId: String?,
    ): Result<Album>

    suspend fun searchAlbum(phrase: String?): Result<List<Album>>

    suspend fun addAlbumToFavorites(albumMbId: String): Result<Unit>

    suspend fun removeAlbumFromFavorites(albumMbId: String): Result<Unit>

    suspend fun isAlbumFavorite(albumMbId: String): Boolean
}
