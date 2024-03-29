package ru.serzh272.nfp.presentation.results

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.serzh272.nfp.model.DomainDataHolder
import ru.serzh272.nfp.results.ResultsScreenUiState
import javax.inject.Inject

@HiltViewModel
class ResultsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _resultsUiState: MutableStateFlow<ResultsScreenUiState> = MutableStateFlow(ResultsScreenUiState(exams = DomainDataHolder.exams))
    val resultsUiState: StateFlow<ResultsScreenUiState> = _resultsUiState

    sealed class ResultsScreenCommand {
    }

    fun handleCommand(command: ResultsScreenCommand) {

    }
}
