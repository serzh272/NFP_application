package ru.serzh272.norms.mapper

import ru.serzh272.data.local.database.entity.ExerciseEntity
import ru.serzh272.norms.model.ExerciseDomain

fun ExerciseEntity.toExercise(): ExerciseDomain {
    return ExerciseDomain(
        id = id,
        name = exerciseName,
        description = description,
        exerciseType = exerciseType,
    )
}

fun ExerciseDomain.toExerciseEntity(): ExerciseEntity {
    return ExerciseEntity(
        id = id,
        exerciseName = name,
        description = description,
        exerciseType = exerciseType,
        icon = iconRes
    )
}
