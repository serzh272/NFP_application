package ru.serzh272.nfp.data.mapper

import ru.serzh272.nfp.data.local.database.entity.ExerciseEntity

fun ExerciseEntity.toExercise(): ru.serzh272.nfp.model.ExerciseDomain {
    return ru.serzh272.nfp.model.ExerciseDomain(
        id = id,
        name = exerciseName,
        description = description,
        exerciseType = exerciseType,
    )
}

fun ru.serzh272.nfp.model.ExerciseDomain.toExerciseEntity(): ExerciseEntity {
    return ExerciseEntity(
        id = id,
        exerciseName = name,
        description = description,
        exerciseType = exerciseType,
        icon = iconRes
    )
}
