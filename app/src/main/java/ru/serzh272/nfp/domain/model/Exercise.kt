package ru.serzh272.nfp.domain.model

import ru.serzh272.nfp.data.local.database.entity.ExerciseEntity

data class Exercise(
    val id: Long,
    val name: String,
    val description: String? = null,
    val exerciseType: ExerciseEntity.ExerciseType,
    val iconRes: Int? = null
)
