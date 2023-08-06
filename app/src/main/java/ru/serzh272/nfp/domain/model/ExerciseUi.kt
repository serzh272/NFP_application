package ru.serzh272.nfp.domain.model

import ru.serzh272.norms.model.Exercise
import ru.serzh272.norms.model.ExerciseTypeDomain

data class ExerciseUi(
    val id: Long,
    val name: String,
    val description: String? = null,
    val exerciseTypeDomain: ExerciseTypeDomain,
    val iconRes: Int? = null
) {
    companion object {
        fun Exercise.toExerciseUi(): ExerciseUi = ExerciseUi(
            id = id,
            name = name,
            description = description,
            exerciseTypeDomain = exerciseType,
            iconRes = iconRes
        )
    }
}
