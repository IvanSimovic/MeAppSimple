package com.simovic.meappsimple.feature.livefeed.presentation.screen.livefeeddetails

import com.simovic.meappsimple.base.presentation.viewmodel.BaseAction
import com.simovic.meappsimple.feature.livefeed.domain.model.FeedItem

internal sealed interface LiveFeedDetailsAction : BaseAction<LiveFeedDetailsUiState> {
    class Content(
        private val feed: FeedItem,
    ) : LiveFeedDetailsAction {
        override fun reduce(state: LiveFeedDetailsUiState) = LiveFeedDetailsUiState.Content(feed)
    }
}
