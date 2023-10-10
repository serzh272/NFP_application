package ru.serzh272.nfp.norms.model

import ru.serzh272.nfp.model.ExerciseDomain
import ru.serzh272.nfp.norms.mapper.toExerciseType

data class ExerciseUi(
    val id: Long,
    val name: String,
    val description: String? = null,
    val exerciseType: ExerciseType,
    val iconRes: Int? = null
) {
    companion object {
        fun ExerciseDomain.toExerciseUi(): ExerciseUi = ExerciseUi(
            id = id,
            name = name,
            description = description,
            exerciseType = exerciseType.toExerciseType(),
            iconRes = iconRes
        )
    }
}
