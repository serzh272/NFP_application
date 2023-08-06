package ru.serzh272.norms.mapper

import ru.serzh272.data.ExerciseType
import ru.serzh272.data.local.database.entity.ExerciseEntity
import ru.serzh272.norms.model.Exercise
import ru.serzh272.norms.model.ExerciseTypeDomain

fun ExerciseEntity.toExercise(): Exercise {
    return Exercise(
        id = id,
        name = exerciseName,
        description = description,
        exerciseType = exerciseType.toExerciseTypeDomain(),
    )
}

fun Exercise.toExerciseEntity(): ExerciseEntity {
    return ExerciseEntity(
        id = id,
        exerciseName = name,
        description = description,
        exerciseType = exerciseType.toExerciseType(),
        icon = iconRes
    )
}

fun ExerciseTypeDomain.toExerciseType(): ExerciseType = when(this) {
    ExerciseTypeDomain.STRENGTH -> ExerciseType.STRENGTH
    ExerciseTypeDomain.SPEED -> ExerciseType.SPEED
    ExerciseTypeDomain.ENDURANCE -> ExerciseType.ENDURANCE
    ExerciseTypeDomain.AGILITY -> ExerciseType.AGILITY
    ExerciseTypeDomain.MILITARY_SKILLS -> ExerciseType.MILITARY_SKILLS
    ExerciseTypeDomain.UNDEFINED -> ExerciseType.UNDEFINED
}

fun ExerciseType.toExerciseTypeDomain():ExerciseTypeDomain  = when(this) {
    ExerciseType.STRENGTH -> ExerciseTypeDomain.STRENGTH
    ExerciseType.SPEED -> ExerciseTypeDomain.SPEED
    ExerciseType.ENDURANCE -> ExerciseTypeDomain.ENDURANCE
    ExerciseType.AGILITY -> ExerciseTypeDomain.AGILITY
    ExerciseType.MILITARY_SKILLS -> ExerciseTypeDomain.MILITARY_SKILLS
    ExerciseType.UNDEFINED -> ExerciseTypeDomain.UNDEFINED
}
