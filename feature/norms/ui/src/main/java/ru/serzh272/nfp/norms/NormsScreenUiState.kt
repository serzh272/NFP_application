package ru.serzh272.nfp.norms

import ru.serzh272.common.constants.EMPTY_STRING
import ru.serzh272.nfp.norms.model.ExerciseType
import ru.serzh272.nfp.norms.model.ExerciseUi

data class NormsScreenUiState(
    val exercises: List<ExerciseUi> = emptyList(),
    val selectionMode: Boolean = false,
    val searchQuery: String = EMPTY_STRING,
    val filterDialogShow: Boolean = false,
    val filter: Set<ExerciseType> = emptySet(),
    val selectedExercises: Set<ExerciseUi> = emptySet(),
) {
    val visibleExercises: List<ExerciseUi>
        get() = exercises.takeIf { selectedExercises.isEmpty() } ?: exercises.filter { all -> all in selectedExercises || all.exerciseType !in selectedExercises.map { it.exerciseType } }
}
