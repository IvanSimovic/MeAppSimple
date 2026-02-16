package com.simovic.meappsimple.feature.birthday.presentation.screen.birthdayadd

import androidx.lifecycle.viewModelScope
import com.simovic.meappsimple.base.presentation.viewmodel.BaseViewModel
import com.simovic.meappsimple.feature.birthday.domain.model.CreateBirthDay
import com.simovic.meappsimple.feature.birthday.domain.repository.BirthDayRepo
import kotlinx.coroutines.launch
import java.time.LocalDate

internal class BirthDayAddViewModel(
    private val birthDayRepo: BirthDayRepo,
) : BaseViewModel<BirthDayAddUiState, BirthDayAddAction>(BirthDayAddUiState.Empty) {
    fun add(
        name: String,
        dayOfMonth: Int,
        month: Int,
    ) {
        viewModelScope.launch {
            if (!name.isEmpty()) {
                birthDayRepo.add(CreateBirthDay(name, LocalDate.of(2000, month, dayOfMonth)))
                sendAction(BirthDayAddAction.Success())
            }
        }
    }
}
