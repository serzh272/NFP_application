package ru.serzh272.nfp.presentation.norms

import ru.serzh272.nfp.core.constants.EMPTY_STRING
import ru.serzh272.nfp.presentation.model.Exercise

data class NormsScreenUiState(
    val exercises: List<Exercise> = emptyList(),
    val selectionMode: Boolean = false,
    val searchQuery: String = EMPTY_STRING,
    val filterDialogShow: Boolean = false,
    val filter: Set<Exercise.ExerciseType> = emptySet(),
    val selectedExercises: Set<Exercise> = emptySet(),
)
