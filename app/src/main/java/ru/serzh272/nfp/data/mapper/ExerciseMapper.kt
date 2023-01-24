package ru.serzh272.nfp.data.mapper

import ru.serzh272.nfp.R
import ru.serzh272.nfp.data.local.database.entity.ExerciseEntity
import ru.serzh272.nfp.domain.model.Exercise

fun ExerciseEntity.toExercise(): Exercise {
    return Exercise(
        id = id,
        name = exerciseName,
        description = description,
        exerciseType = exerciseType,
        iconRes = icon ?: R.drawable.ic_image_placeholder
    )
}

fun Exercise.toExerciseEntity(): ExerciseEntity {
    return ExerciseEntity(
        id = id,
        exerciseName = name,
        description = description,
        exerciseType = exerciseType,
        icon = iconRes
    )
}
