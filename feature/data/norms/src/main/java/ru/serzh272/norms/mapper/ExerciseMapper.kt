package ru.serzh272.norms.mapper

import ru.serzh272.data.local.database.entity.ExerciseEntity
import ru.serzh272.norms.model.Exercise

fun ExerciseEntity.toExercise(): Exercise {
    return Exercise(
        id = id,
        name = exerciseName,
        description = description,
        exerciseType = exerciseType,
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
