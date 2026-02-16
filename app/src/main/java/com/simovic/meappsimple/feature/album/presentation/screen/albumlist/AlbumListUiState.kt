package com.simovic.meappsimple.feature.album.presentation.screen.albumlist

import androidx.compose.runtime.Immutable
import com.simovic.meappsimple.base.presentation.viewmodel.BaseState
import com.simovic.meappsimple.feature.album.domain.model.Album

@Immutable
internal sealed interface AlbumListUiState : BaseState {
    @Immutable
    data class Content(
        val albums: List<Album>,
    ) : AlbumListUiState

    @Immutable
    data object Loading : AlbumListUiState

    @Immutable
    data object Error : AlbumListUiState
}
