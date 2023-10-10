package ru.serzh272.nfp.norms

import ru.serzh272.common.constants.EMPTY_STRING
import ru.serzh272.nfp.norms.model.ExerciseUi

data class NormsScreenUiState(
    val exercises: List<ExerciseUi> = emptyList(),
    val selectionMode: Boolean = false,
    val searchQuery: String = EMPTY_STRING,
    val filterDialogShow: Boolean = false,
    val filter: Set<ru.serzh272.nfp.model.ExerciseTypeDomain> = emptySet(),
    val selectedExercises: Set<ExerciseUi> = emptySet(),
)
