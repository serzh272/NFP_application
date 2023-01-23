package ru.serzh272.nfp.presentation.model

object DataHolder {
    val exercises: List<Exercise> = listOf(
        Exercise(1, "1. Сгибание, разгибание рук в упоре лежа", Exercise.ExerciseType.STRENGTH),
        Exercise(2, "2. Наклоны туловища вперед", Exercise.ExerciseType.SPEED),
        Exercise(4, "4. Подтягивание на перекладине", Exercise.ExerciseType.STRENGTH),
        Exercise(5, "5. Поднимание ног к перекладине", Exercise.ExerciseType.SPEED),
        Exercise(6, "6. Подъем переворотом на перекладине", Exercise.ExerciseType.STRENGTH),
    )
}
