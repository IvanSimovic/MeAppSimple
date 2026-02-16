package com.simovic.meappsimple.feature.birthday.presentation.screen.birthdayadd

import com.simovic.meappsimple.base.presentation.viewmodel.BaseAction

internal sealed interface BirthDayAddAction : BaseAction<BirthDayAddUiState> {
    class Success : BirthDayAddAction {
        override fun reduce(state: BirthDayAddUiState) = BirthDayAddUiState.Success
    }
}
