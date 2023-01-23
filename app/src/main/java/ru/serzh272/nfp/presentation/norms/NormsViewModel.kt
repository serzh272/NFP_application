package ru.serzh272.nfp.presentation.norms

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.serzh272.nfp.presentation.model.DataHolder
import ru.serzh272.nfp.presentation.model.Exercise
import javax.inject.Inject

@HiltViewModel
class NormsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _exercisesStateFlow = MutableStateFlow(DataHolder.exercises)
    val exercisesStateFlow: StateFlow<List<Exercise>> = _exercisesStateFlow

    private val _normsUiState: MutableStateFlow<NormsScreenUiState> = MutableStateFlow(NormsScreenUiState(exercises = _exercisesStateFlow.value))
    val normsUiState: StateFlow<NormsScreenUiState> = _normsUiState

    fun setUiState(state: NormsScreenUiState) {
        _normsUiState.value = state.copy(exercises = if (state.searchQuery.isBlank()) exercisesStateFlow.value else exercisesStateFlow.value.filter { it.description.contains(state.searchQuery, true) })
            .let { res -> if (res.filter.isEmpty()) res else res.copy(exercises =  res.exercises.filter { res.filter.contains(it.exerciseType) }) }
    }

    private fun handleItemSelection(item: Exercise){
        with(normsUiState.value){
            if (item in selectedExercises && selectedExercises.size == 1 || selectedExercises.isEmpty()) {
                setUiState(copy(selectionMode = false, selectedExercises = emptySet()))
            } else {
                setUiState(copy(selectedExercises = if (item in selectedExercises) selectedExercises - item else selectedExercises + item))
            }
        }
    }

    fun handleCommand(command: NormsScreenCommand){
        when(command){
            is NormsScreenCommand.ChangeUiState -> setUiState(command.uiState)
            is NormsScreenCommand.SelectItem -> handleItemSelection(command.item)
            is NormsScreenCommand.AddToComplex -> handleAddToComplex(command.exercises)
        }
    }

    private fun handleAddToComplex(exercises: Set<Exercise>){
        setUiState(NormsScreenUiState(exercisesStateFlow.value))
        Log.d("M_NormsViewModel", "$exercises")
    }

    sealed class NormsScreenCommand{
        data class ChangeUiState(val uiState: NormsScreenUiState): NormsScreenCommand()
        data class SelectItem(val item: Exercise): NormsScreenCommand()
        data class AddToComplex(val exercises: Set<Exercise>): NormsScreenCommand()
    }
}
