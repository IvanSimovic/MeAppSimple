package com.simovic.meappsimple.feature.livefeed.presentation.screen.livefeeddetails

import androidx.compose.runtime.Immutable
import com.simovic.meappsimple.base.presentation.viewmodel.BaseState
import com.simovic.meappsimple.feature.livefeed.domain.model.FeedItem

@Immutable
internal sealed interface LiveFeedDetailsUiState : BaseState {
    @Immutable
    data object Loading : LiveFeedDetailsUiState

    @Immutable
    data class Content(
        val feed: FeedItem,
    ) : LiveFeedDetailsUiState
}
