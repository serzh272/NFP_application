package ru.serzh272.nfp.presentation.norms

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import ru.serzh272.nfp.domain.model.Exercise
import ru.serzh272.nfp.domain.usecase.GetExercisesUseCase
import javax.inject.Inject

@HiltViewModel
class NormsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    getExercisesUseCase: GetExercisesUseCase,
) : ViewModel() {

    private var disposables = CompositeDisposable()

    private var allExercises: List<Exercise> = listOf()

    private val exercisesSubscription: Observable<List<Exercise>> = getExercisesUseCase()

    private val _normsUiState: BehaviorSubject<NormsScreenUiState> = BehaviorSubject.createDefault(NormsScreenUiState())
    val normsUiState: Observable<NormsScreenUiState> = _normsUiState

    init {
        exercisesSubscription.subscribeOn(Schedulers.io())
            .subscribe {
                allExercises = it
                val selectedExercises = _normsUiState.value!!.selectedExercises.intersect(allExercises.toSet())
                val selectionMode = selectedExercises.isNotEmpty()
                setUiState(_normsUiState.value!!.copy(exercises = allExercises, selectedExercises = selectedExercises, selectionMode = selectionMode))
            }.also {
                disposables.add(it)
            }
    }

    fun setUiState(state: NormsScreenUiState) {
        _normsUiState.onNext(state.copy(exercises = if (state.searchQuery.isBlank()) allExercises else allExercises.filter {
            it.name.contains(
                state.searchQuery,
                true
            )
        }).let { res -> if (res.filter.isEmpty()) res else res.copy(exercises = res.exercises.filter { res.filter.contains(it.exerciseType) }) })
    }

    private fun handleItemSelection(item: Exercise) {
        with(_normsUiState.value!!) {
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

    private fun handleAddToComplex(exercises: Set<Exercise>) {
        setUiState(NormsScreenUiState(allExercises))
        Log.d("M_NormsViewModel", "$exercises")
    }

    sealed class NormsScreenCommand {
        data class ChangeUiState(val uiState: NormsScreenUiState) : NormsScreenCommand()
        data class SelectItem(val item: Exercise) : NormsScreenCommand()
        data class AddToComplex(val exercises: Set<Exercise>) : NormsScreenCommand()
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}
