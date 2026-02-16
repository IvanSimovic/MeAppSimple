package com.simovic.meappsimple.feature.birthday

import com.simovic.meappsimple.feature.birthday.data.dataModule
import com.simovic.meappsimple.feature.birthday.presentation.presentationModule

val featureBirthDayModules =
    listOf(
        presentationModule,
        dataModule,
    )
