package com.simovic.meappsimple.feature.birthday.presentation.screen.birthdaylist

import com.simovic.meappsimple.base.util.toBirthDay
import com.simovic.meappsimple.feature.birthday.domain.model.BirthDay

data class BirthDayListModel(
    val id: Long,
    val name: String,
    val date: String,
    val isMarkedForDelete: Boolean,
)

fun List<BirthDay>.toBirthDayListModel() = this.map { it.toBirthDayListModel() }

fun BirthDay.toBirthDayListModel() =
    BirthDayListModel(
        id = id,
        name = name,
        date = date.toBirthDay(),
        isMarkedForDelete = false,
    )
