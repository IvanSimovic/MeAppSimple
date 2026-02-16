package com.simovic.meappsimple.feature.livefeed.presentation.screen.livefeed

import androidx.lifecycle.viewModelScope
import com.simovic.meappsimple.base.domain.result.Result
import com.simovic.meappsimple.base.presentation.viewmodel.BaseViewModel
import com.simovic.meappsimple.feature.livefeed.domain.repository.LiveFeedRepo
import com.simovic.meappsimple.feature.livefeed.presentation.screen.livefeed.LiveFeedAction.Success
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class LiveFeedViewModel(
    private val liveFeedRepo: LiveFeedRepo,
) : BaseViewModel<LiveFeedUiState, LiveFeedAction>(LiveFeedUiState.Loading) {
    private var job: Job? = null

    fun getFeed() {
        if (job != null) {
            job?.cancel()
            job = null
        }

        job =
            viewModelScope.launch {
                liveFeedRepo.getFeed().also { result ->
                    val liveFeedAction =
                        when (result) {
                            is Result.Success -> {
                                result.value?.let { Success(it) }
                                    ?: LiveFeedAction.AlbumListLoadFailure
                            }

                            is Result.Failure -> {
                                LiveFeedAction.AlbumListLoadFailure
                            }
                        }
                    sendAction(liveFeedAction)
                }
            }
    }
}
