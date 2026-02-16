package com.simovic.meappsimple.feature.livefeed.presentation.screen.livefeed

import androidx.compose.runtime.Immutable
import com.simovic.meappsimple.base.presentation.viewmodel.BaseState
import com.simovic.meappsimple.feature.livefeed.domain.model.FeedItem

@Immutable
internal sealed interface LiveFeedUiState : BaseState {
    @Immutable
    data class Content(
        val feed: List<FeedItem>,
    ) : LiveFeedUiState

    @Immutable
    data object Loading : LiveFeedUiState

    @Immutable
    data object Error : LiveFeedUiState
}
