package ru.serzh272.norms.model

data class ExerciseUi(
    val id: Long,
    val name: String,
    val description: String? = null,
    val exerciseTypeDomain: ExerciseTypeDomain,
    val iconRes: Int? = null
) {
    companion object {
        fun ExerciseDomain.toExerciseUi(): ExerciseUi = ExerciseUi(
            id = id,
            name = name,
            description = description,
            exerciseTypeDomain = exerciseType,
            iconRes = iconRes
        )
    }
}
