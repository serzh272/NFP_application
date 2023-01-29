package ru.serzh272.nfp.presentation.norms

import ru.serzh272.nfp.core.constants.EMPTY_STRING
import ru.serzh272.nfp.data.local.database.entity.enums.ExerciseType
import ru.serzh272.nfp.domain.model.Exercise

data class NormsScreenUiState(
    val exercises: List<Exercise> = emptyList(),
    val selectionMode: Boolean = false,
    val searchQuery: String = EMPTY_STRING,
    val filterDialogShow: Boolean = false,
    val filter: Set<ExerciseType> = emptySet(),
    val selectedExercises: Set<Exercise> = emptySet(),
)
