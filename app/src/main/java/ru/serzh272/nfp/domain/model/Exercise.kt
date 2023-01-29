package ru.serzh272.nfp.domain.model

import ru.serzh272.nfp.data.local.database.entity.enums.ExerciseType

data class Exercise(
    val id: Long,
    val name: String,
    val description: String? = null,
    val exerciseType: ExerciseType,
    val iconRes: Int? = null
)
