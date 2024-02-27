package ru.serzh272.nfp.presentation.model

sealed interface RootEvent {
    sealed class ShowMessage(val message: String) : RootEvent {
        class Success(message: String) : ShowMessage(message)
        class Error(message: String) : ShowMessage(message)
        class Warning(message: String) : ShowMessage(message)
    }
    class ShowDialog(val message: String) : RootEvent
}
