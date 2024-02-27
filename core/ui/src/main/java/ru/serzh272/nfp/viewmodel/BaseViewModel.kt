package ru.serzh272.nfp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseViewModel<ViewState : BaseViewModel.BaseViewState, ViewAction : BaseViewModel.BaseAction>(initialState: ViewState) : ViewModel() {

    private val _stateFlow: MutableStateFlow<ViewState> = MutableStateFlow(initialState)
    val stateFlow: StateFlow<ViewState> = _stateFlow
    val state : ViewState
        get() = _stateFlow.value

    interface BaseViewState

    interface BaseAction

    protected abstract fun onStateChanged(action: ViewAction) : ViewState

    fun sendAction(action: ViewAction) {
        _stateFlow.update { onStateChanged(action) }
    }
}
