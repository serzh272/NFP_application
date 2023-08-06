package ru.serzh272.norms.mapper

import ru.serzh272.norms.model.ExerciseType
import ru.serzh272.norms.model.ExerciseTypeDomain


fun ExerciseTypeDomain.toExerciseType(): ExerciseType = when(this) {
    ExerciseTypeDomain.STRENGTH -> ExerciseType.STRENGTH
    ExerciseTypeDomain.SPEED -> ExerciseType.SPEED
    ExerciseTypeDomain.ENDURANCE -> ExerciseType.ENDURANCE
    ExerciseTypeDomain.AGILITY -> ExerciseType.AGILITY
    ExerciseTypeDomain.MILITARY_SKILLS -> ExerciseType.MILITARY_SKILLS
    ExerciseTypeDomain.UNDEFINED -> ExerciseType.UNDEFINED
}

fun ExerciseType.toExerciseTypeDomain(): ExerciseTypeDomain = when(this) {
    ExerciseType.STRENGTH -> ExerciseTypeDomain.STRENGTH
    ExerciseType.SPEED -> ExerciseTypeDomain.SPEED
    ExerciseType.ENDURANCE -> ExerciseTypeDomain.ENDURANCE
    ExerciseType.AGILITY -> ExerciseTypeDomain.AGILITY
    ExerciseType.MILITARY_SKILLS -> ExerciseTypeDomain.MILITARY_SKILLS
    ExerciseType.UNDEFINED -> ExerciseTypeDomain.UNDEFINED
}
