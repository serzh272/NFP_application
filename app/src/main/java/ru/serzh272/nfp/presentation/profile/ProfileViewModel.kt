package ru.serzh272.nfp.presentation.profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.serzh272.nfp.domain.usecase.GetProfileUseCase
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    profileUseCase: GetProfileUseCase,
) : ViewModel() {

    private val _profileUiState: MutableStateFlow<ProfileScreenUiState> = MutableStateFlow(ProfileScreenUiState())
    val profileUiState: StateFlow<ProfileScreenUiState> = _profileUiState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            profileUseCase().collect{
                setUiState(ProfileScreenUiState(it))
            }
        }
    }

    fun setUiState(state: ProfileScreenUiState){
        _profileUiState.value = state
    }

    fun handleCommand(command: ProfileScreenCommand){
        TODO()
    }

    sealed class ProfileScreenCommand{
    }
}
