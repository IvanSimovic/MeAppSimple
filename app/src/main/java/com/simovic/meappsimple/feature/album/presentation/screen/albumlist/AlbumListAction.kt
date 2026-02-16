package com.simovic.meappsimple.feature.album.presentation.screen.albumlist

import com.simovic.meappsimple.base.presentation.viewmodel.BaseAction
import com.simovic.meappsimple.feature.album.domain.model.Album

internal sealed interface AlbumListAction : BaseAction<AlbumListUiState> {
    object AlbumListLoadStart : AlbumListAction {
        override fun reduce(state: AlbumListUiState) = AlbumListUiState.Loading
    }

    class AlbumListLoadSuccess(
        private val albums: List<Album>,
    ) : AlbumListAction {
        override fun reduce(state: AlbumListUiState) = AlbumListUiState.Content(albums)
    }

    object AlbumListLoadFailure : AlbumListAction {
        override fun reduce(state: AlbumListUiState) = AlbumListUiState.Error
    }
}
