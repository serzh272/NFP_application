package ru.serzh272.nfp.model


data class ExerciseDomain(
    val id: Long,
    val name: String,
    val description: String? = null,
    val exerciseType: ExerciseTypeDomain,
    val iconRes: Int? = null
)
