package com.simovic.meappsimple.feature.album

import com.simovic.meappsimple.feature.album.data.dataModule
import com.simovic.meappsimple.feature.album.domain.domainModule
import com.simovic.meappsimple.feature.album.presentation.presentationModule

val featureAlbumModules =
    listOf(
        presentationModule,
        domainModule,
        dataModule,
    )
