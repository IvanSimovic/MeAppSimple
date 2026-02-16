package com.simovic.meappsimple.base.presentation.viewmodel

interface BaseAction<State> {
    fun reduce(state: State): State
}
