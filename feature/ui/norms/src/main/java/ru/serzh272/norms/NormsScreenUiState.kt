package ru.serzh272.norms

import ru.serzh272.common.constants.EMPTY_STRING
import ru.serzh272.norms.model.ExerciseTypeDomain
import ru.serzh272.norms.model.ExerciseUi

data class NormsScreenUiState(
    val exercises: List<ExerciseUi> = emptyList(),
    val selectionMode: Boolean = false,
    val searchQuery: String = EMPTY_STRING,
    val filterDialogShow: Boolean = false,
    val filter: Set<ExerciseTypeDomain> = emptySet(),
    val selectedExercises: Set<ExerciseUi> = emptySet(),
)
