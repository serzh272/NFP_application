package ru.serzh272.nfp.presentation.norms

import ru.serzh272.common.constants.EMPTY_STRING
import ru.serzh272.data.ExerciseType
import ru.serzh272.nfp.domain.model.ExerciseUi

data class NormsScreenUiState(
    val exercises: List<ExerciseUi> = emptyList(),
    val selectionMode: Boolean = false,
    val searchQuery: String = EMPTY_STRING,
    val filterDialogShow: Boolean = false,
    val filter: Set<ExerciseType> = emptySet(),
    val selectedExercises: Set<ExerciseUi> = emptySet(),
)
