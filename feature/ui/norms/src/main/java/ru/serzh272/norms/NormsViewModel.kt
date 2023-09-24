package ru.serzh272.norms

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ru.serzh272.nfp.norms.usecase.GetExercisesUseCase
import ru.serzh272.norms.model.ExerciseUi
import ru.serzh272.norms.model.ExerciseUi.Companion.toExerciseUi
import javax.inject.Inject

@HiltViewModel
class NormsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    getExercisesUseCase: GetExercisesUseCase,
) : ViewModel() {

    private var allExercises: List<ExerciseUi> = listOf()

    private val exercisesFlow: Flow<List<ExerciseUi>> = getExercisesUseCase().map { exercises -> exercises.map { exercise -> exercise.toExerciseUi() } }

    private val _normsUiState: MutableStateFlow<NormsScreenUiState> = MutableStateFlow(NormsScreenUiState())
    val normsUiState: StateFlow<NormsScreenUiState> = _normsUiState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            exercisesFlow.collect {
                allExercises = it
                val selectedExercises = normsUiState.value.selectedExercises.intersect(allExercises.toSet())
                val selectionMode = selectedExercises.isNotEmpty()
                setUiState(normsUiState.value.copy(exercises = allExercises, selectedExercises = selectedExercises, selectionMode = selectionMode))
            }
        }
    }

    fun setUiState(state: NormsScreenUiState) {
        _normsUiState.value = state.copy(exercises = if (state.searchQuery.isBlank()) allExercises else allExercises.filter {
            it.name.contains(
                state.searchQuery,
                true
            )
        }).let { res -> if (res.filter.isEmpty()) res else res.copy(exercises = res.exercises.filter { res.filter.contains(it.exerciseTypeDomain) }) }
    }

    private fun handleItemSelection(item: ExerciseUi) {
        with(normsUiState.value) {
            if (item in selectedExercises && selectedExercises.size == 1 || selectedExercises.isEmpty()) {
                setUiState(copy(selectionMode = false, selectedExercises = emptySet()))
            } else {
                setUiState(copy(selectedExercises = if (item in selectedExercises) selectedExercises - item else selectedExercises + item))
            }
        }
    }

    fun handleCommand(command: NormsScreenCommand) {
        when (command) {
            is NormsScreenCommand.ChangeUiState -> setUiState(command.uiState)
            is NormsScreenCommand.SelectItem -> handleItemSelection(command.item)
            is NormsScreenCommand.AddToComplex -> handleAddToComplex(command.exercises)
        }
    }

    private fun handleAddToComplex(exercises: Set<ExerciseUi>) {
        setUiState(NormsScreenUiState(allExercises))
        Log.d("M_NormsViewModel", "$exercises")
    }

    sealed class NormsScreenCommand {
        data class ChangeUiState(val uiState: NormsScreenUiState) : NormsScreenCommand()
        data class SelectItem(val item: ExerciseUi) : NormsScreenCommand()
        data class AddToComplex(val exercises: Set<ExerciseUi>) : NormsScreenCommand()
    }

    override fun onCleared() {
        Log.d("M_NormsViewModel", "cleared")
        super.onCleared()
    }
}
