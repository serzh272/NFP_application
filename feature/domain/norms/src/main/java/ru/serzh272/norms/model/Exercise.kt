package ru.serzh272.norms.model


data class Exercise(
    val id: Long,
    val name: String,
    val description: String? = null,
    val exerciseType: ExerciseTypeDomain,
    val iconRes: Int? = null
)
