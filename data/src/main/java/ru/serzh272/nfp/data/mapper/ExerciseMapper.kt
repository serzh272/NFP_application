package ru.serzh272.nfp.data.mapper

import ru.serzh272.nfp.data.local.database.entity.ExerciseEntity
import ru.serzh272.nfp.model.ExerciseDomain

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
