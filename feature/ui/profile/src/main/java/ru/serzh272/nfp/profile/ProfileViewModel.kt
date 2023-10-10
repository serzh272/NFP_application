package ru.serzh272.nfp.profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.serzh272.common.constants.EMPTY_STRING
import ru.serzh272.nfp.profile.model.UserFullInfo
import ru.serzh272.nfp.profile.usecase.GetProfileUseCase
import ru.serzh272.nfp.viewmodel.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    profileUseCase: GetProfileUseCase,
) : BaseViewModel<ProfileViewModel.ViewState, ProfileViewModel.Action>(ViewState()) {

    init {
        profileUseCase().onEach { userInfo ->
            sendAction(Action.SetUserData(userInfo))
        }.launchIn(viewModelScope)
    }

    data class ViewState(
        val error: Int = 0,
        val userInfo: UserFullInfo = UserFullInfo(
            id = 0,
            category = null,
            ageGroup = null,
            userCategory = -1L to EMPTY_STRING
        ),
    ) : BaseViewState

    sealed interface Action : BaseAction {
        class SetUserData(val data: UserFullInfo) : Action
    }

    fun handleCommand(command: ProfileScreenCommand){
        TODO()
    }

    sealed class ProfileScreenCommand{
    }

    override fun onStateChanged(action: Action): ViewState {
        return when(action) {
            is Action.SetUserData -> state.copy(userInfo = action.data)
        }
    }
}
