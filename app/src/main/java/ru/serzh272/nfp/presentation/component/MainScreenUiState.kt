package ru.serzh272.nfp.presentation.component

sealed class MainScreenUiState {
    data class CurrentRootDestination(val root: String)
}
