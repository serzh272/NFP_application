package ru.serzh272.nfp.data.local

import ru.serzh272.nfp.data.local.database.entity.ExerciseEntity
import ru.serzh272.nfp.data.local.database.entity.enums.ExerciseType

object DataHolder {
    val exercises: List<ExerciseEntity> = listOf(
        ExerciseEntity(id = 1, exerciseName = "1. Сгибание, разгибание рук в упоре лежа.", exerciseType = ExerciseType.STRENGTH),
        ExerciseEntity(id = 2, exerciseName = "2. Наклоны туловища вперед.", exerciseType = ExerciseType.STRENGTH),
        ExerciseEntity(id = 4, exerciseName = "4. Подтягивание на перекладине.", exerciseType = ExerciseType.STRENGTH),
        ExerciseEntity(id = 5, exerciseName = "5. Поднимание ног к перекладине.", exerciseType = ExerciseType.STRENGTH),
        ExerciseEntity(id = 6, exerciseName = "6. Подъем переворотом на перекладине.", exerciseType = ExerciseType.STRENGTH),
        ExerciseEntity(id = 7, exerciseName = "7. Подъем силой на перекладине.", exerciseType = ExerciseType.STRENGTH),
        ExerciseEntity(id = 8, exerciseName = "8. Жим штанги лежа. Вес штанги - 70 кг.", exerciseType = ExerciseType.STRENGTH),
        ExerciseEntity(id = 9, exerciseName = "9. Сгибание и разгибание рук в упоре на брусьях.", exerciseType = ExerciseType.STRENGTH),
        ExerciseEntity(id = 10, exerciseName = "10. Угол в упоре на брусьях.", exerciseType = ExerciseType.STRENGTH),
        ExerciseEntity(id = 11, exerciseName = "11. Рывок гири. Вес гири 24 кг.", exerciseType = ExerciseType.STRENGTH),
        ExerciseEntity(id = 12, exerciseName = "12. Толчок двух гирь. Вес гири 24 кг.", exerciseType = ExerciseType.STRENGTH),
        ExerciseEntity(id = 13, exerciseName = "13. Толчок двух гирь по длинному циклу. Вес гири 24 кг", exerciseType = ExerciseType.STRENGTH),
        ExerciseEntity(id = 14, exerciseName = "14. Прыжок согнув ноги через коня (козла) в ширину.", exerciseType = ExerciseType.AGILITY),
        ExerciseEntity(id = 15, exerciseName = "15. Прыжок ноги врозь через козла в длину.", exerciseType = ExerciseType.AGILITY),
        ExerciseEntity(id = 16, exerciseName = "16. Прыжок ноги врозь через коня в длину.", exerciseType = ExerciseType.AGILITY),
        ExerciseEntity(id = 17, exerciseName = "17. Кувырок вперед.", exerciseType = ExerciseType.AGILITY),
    )
}
