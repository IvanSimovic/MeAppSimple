package com.simovic.meappsimple.feature.livefeed.domain.repository

import com.simovic.meappsimple.base.domain.result.Result
import com.simovic.meappsimple.feature.livefeed.domain.model.FeedItem

internal interface LiveFeedRepo {
    suspend fun getFeed(): Result<List<FeedItem>?>
}
