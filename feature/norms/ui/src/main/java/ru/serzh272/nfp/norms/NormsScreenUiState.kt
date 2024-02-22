package ru.serzh272.nfp.norms

import androidx.compose.runtime.Stable
import ru.serzh272.common.constants.EMPTY_STRING
import ru.serzh272.nfp.norms.model.ExerciseType
import ru.serzh272.nfp.norms.model.ExerciseUi

@Stable
data class NormsScreenUiState(
    val exercises: Map<ExerciseType, List<ExerciseUi>>,
    val selectionMode: Boolean,
    val searchQuery: String,
    val filterDialogShow: Boolean,
    val filter: Set<ExerciseType>,
    val selectedExercises: Set<ExerciseUi>,
) {
    companion object {

        val EMPTY = NormsScreenUiState(
            exercises = emptyMap(),
            selectionMode = false,
            searchQuery = EMPTY_STRING,
            filterDialogShow = false,
            filter = emptySet(),
            selectedExercises = emptySet()
        )
    }
}
