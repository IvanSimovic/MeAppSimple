package com.simovic.meappsimple.feature.album.domain.model

import com.simovic.meappsimple.feature.album.domain.enum.ImageSize

internal data class Image(
    val url: String,
    val size: ImageSize,
)
