package ru.serzh272.norms.mapper

import ru.serzh272.norms.model.ExerciseType


fun ru.serzh272.nfp.model.ExerciseTypeDomain.toExerciseType(): ExerciseType = when(this) {
    ru.serzh272.nfp.model.ExerciseTypeDomain.STRENGTH -> ExerciseType.STRENGTH
    ru.serzh272.nfp.model.ExerciseTypeDomain.SPEED -> ExerciseType.SPEED
    ru.serzh272.nfp.model.ExerciseTypeDomain.ENDURANCE -> ExerciseType.ENDURANCE
    ru.serzh272.nfp.model.ExerciseTypeDomain.AGILITY -> ExerciseType.AGILITY
    ru.serzh272.nfp.model.ExerciseTypeDomain.MILITARY_SKILLS -> ExerciseType.MILITARY_SKILLS
    ru.serzh272.nfp.model.ExerciseTypeDomain.UNDEFINED -> ExerciseType.UNDEFINED
}

fun ExerciseType.toExerciseTypeDomain(): ru.serzh272.nfp.model.ExerciseTypeDomain = when(this) {
    ExerciseType.STRENGTH -> ru.serzh272.nfp.model.ExerciseTypeDomain.STRENGTH
    ExerciseType.SPEED -> ru.serzh272.nfp.model.ExerciseTypeDomain.SPEED
    ExerciseType.ENDURANCE -> ru.serzh272.nfp.model.ExerciseTypeDomain.ENDURANCE
    ExerciseType.AGILITY -> ru.serzh272.nfp.model.ExerciseTypeDomain.AGILITY
    ExerciseType.MILITARY_SKILLS -> ru.serzh272.nfp.model.ExerciseTypeDomain.MILITARY_SKILLS
    ExerciseType.UNDEFINED -> ru.serzh272.nfp.model.ExerciseTypeDomain.UNDEFINED
}
