package ru.serzh272.nfp.norms

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.serzh272.common.constants.EMPTY_STRING
import ru.serzh272.nfp.norms.model.ExerciseType
import ru.serzh272.nfp.norms.model.ExerciseUi
import ru.serzh272.nfp.norms.model.ExerciseUi.Companion.toExerciseUi
import ru.serzh272.nfp.norms.usecase.GetExercisesUseCase
import ru.serzh272.nfp.viewmodel.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class NormsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    getExercisesUseCase: GetExercisesUseCase,
) : BaseViewModel<NormsViewModel.ViewState, NormsViewModel.Action>(ViewState.EMPTY) {

    private var allExercises: List<ExerciseUi> = listOf()

    private val exercisesFlow: Flow<List<ExerciseUi>> = getExercisesUseCase().map { exercises -> exercises.map { exercise -> exercise.toExerciseUi() } }

    private val _event = Channel<Event>(Channel.BUFFERED)
    val eventFlow = _event.receiveAsFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            exercisesFlow.collect {
                allExercises = it
                val selectedExercises = stateFlow.value.selectedExercises.intersect(allExercises.toSet())
                val selectionMode = selectedExercises.isNotEmpty()
                val newState = stateFlow.value.copy(exercises = allExercises.groupBy { exercise -> exercise.exerciseType }, selectedExercises = selectedExercises, selectionMode = selectionMode)
                sendAction(Action.ChangeUiState(newState))
            }
        }
    }

    fun ViewState.withGroupedExercises(): ViewState {
        val filtered = (if (searchQuery.isBlank()) allExercises else allExercises.filter {
            it.name.contains(
                searchQuery,
                true
            )
        }).run { takeIf { filter.isEmpty() } ?: filter { filter.contains(it.exerciseType) } }
            .filter { exercise ->
                exercise.exerciseType !in selectedExercises.map { it.exerciseType } ||
                    exercise in selectedExercises
            }
        val grouped = filtered.groupBy { it.exerciseType }
        return copy(exercises = grouped)
    }

    private fun ViewState.withSelectedItem(item: ExerciseUi): ViewState {
        return if (item in selectedExercises && selectedExercises.size == 1 || selectedExercises.isEmpty()) {
            copy(selectionMode = false, selectedExercises = emptySet())
        } else {
            copy(
                selectedExercises = if (item in selectedExercises) {
                    selectedExercises - item
                } else {
                    selectedExercises + item
                }
            )
        }
    }

    sealed interface Action : BaseAction {
        data class ChangeUiState(val uiState: ViewState) : Action
        data class SelectItem(val item: ExerciseUi) : Action
        data class AddToComplex(val exercises: Set<ExerciseUi>) : Action
    }

    override fun onStateChanged(action: Action): ViewState {
        return when (action) {
            is Action.ChangeUiState -> action.uiState
            is Action.SelectItem -> state.withSelectedItem(action.item)
            is Action.AddToComplex -> {
                viewModelScope.launch {
                    _event.send(Event.AddToComplex(action.exercises))
                }
                ViewState.EMPTY.copy(exercises = allExercises.groupBy { it.exerciseType })
            }
        }.withGroupedExercises()
    }

    data class ViewState(
        val exercises: Map<ExerciseType, List<ExerciseUi>>,
        val selectionMode: Boolean,
        val searchQuery: String,
        val filterDialogShow: Boolean,
        val filter: Set<ExerciseType>,
        val selectedExercises: Set<ExerciseUi>,
    ) : BaseViewState {

        companion object {

            val EMPTY = ViewState(
                exercises = emptyMap(),
                selectionMode = false,
                searchQuery = EMPTY_STRING,
                filterDialogShow = false,
                filter = emptySet(),
                selectedExercises = emptySet()
            )
        }
    }

    sealed interface Event {
        class AddToComplex(val exercises: Set<ExerciseUi>) : Event
    }
}
