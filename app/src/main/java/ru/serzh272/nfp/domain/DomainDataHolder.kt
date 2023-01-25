package ru.serzh272.nfp.domain

import ru.serzh272.nfp.data.local.database.entity.ExerciseEntity
import ru.serzh272.nfp.domain.model.Exam
import ru.serzh272.nfp.domain.model.Exercise
import ru.serzh272.nfp.domain.model.ExerciseWithResult
import java.util.*

object DomainDataHolder {
    val exercises: List<Exercise> = listOf(
        Exercise(id = 1, name = "1. Сгибание, разгибание рук в упоре лежа.", exerciseType = ExerciseEntity.ExerciseType.STRENGTH),
        Exercise(id = 2, name = "2. Наклоны туловища вперед.", exerciseType = ExerciseEntity.ExerciseType.STRENGTH),
        Exercise(id = 4, name = "4. Подтягивание на перекладине.", exerciseType = ExerciseEntity.ExerciseType.STRENGTH),
        Exercise(id = 5, name = "5. Поднимание ног к перекладине.", exerciseType = ExerciseEntity.ExerciseType.STRENGTH),
        Exercise(id = 6, name = "6. Подъем переворотом на перекладине.", exerciseType = ExerciseEntity.ExerciseType.STRENGTH),
        Exercise(id = 7, name = "7. Подъем силой на перекладине.", exerciseType = ExerciseEntity.ExerciseType.STRENGTH),
        Exercise(id = 8, name = "8. Жим штанги лежа. Вес штанги - 70 кг.", exerciseType = ExerciseEntity.ExerciseType.STRENGTH),
        Exercise(id = 9, name = "9. Сгибание и разгибание рук в упоре на брусьях.", exerciseType = ExerciseEntity.ExerciseType.STRENGTH),
        Exercise(id = 10, name = "10. Угол в упоре на брусьях.", exerciseType = ExerciseEntity.ExerciseType.STRENGTH),
        Exercise(id = 11, name = "11. Рывок гири. Вес гири 24 кг.", exerciseType = ExerciseEntity.ExerciseType.STRENGTH),
        Exercise(id = 12, name = "12. Толчок двух гирь. Вес гири 24 кг.", exerciseType = ExerciseEntity.ExerciseType.STRENGTH),
        Exercise(id = 13, name = "13. Толчок двух гирь по длинному циклу. Вес гири 24 кг", exerciseType = ExerciseEntity.ExerciseType.STRENGTH),
        Exercise(id = 14, name = "14. Прыжок согнув ноги через коня (козла) в ширину.", exerciseType = ExerciseEntity.ExerciseType.AGILITY),
        Exercise(id = 15, name = "15. Прыжок ноги врозь через козла в длину.", exerciseType = ExerciseEntity.ExerciseType.AGILITY),
        Exercise(id = 16, name = "16. Прыжок ноги врозь через коня в длину.", exerciseType = ExerciseEntity.ExerciseType.AGILITY),
        Exercise(id = 17, name = "17. Кувырок вперед.", exerciseType = ExerciseEntity.ExerciseType.AGILITY),
    )

    val exams: List<Exam> = listOf(
        Exam(id = 1, date = Date(), exercises = exercises.take(4).mapIndexed { index, ex -> ExerciseWithResult(ex, ExerciseWithResult.ExerciseResult.Count(4*index)) }.toSet()),
        Exam(id = 2, date = Date(), exercises = exercises.subList(4, 6).mapIndexed { index, ex -> ExerciseWithResult(ex, ExerciseWithResult.ExerciseResult.Count(3*index)) }.toSet()),
        Exam(id = 3, date = Date(), exercises = exercises.subList(7, 11).mapIndexed { index, ex -> ExerciseWithResult(ex, ExerciseWithResult.ExerciseResult.Count(5*index)) }.toSet()),
        Exam(id = 4, date = Date(), exercises = exercises.subList(5, 8).mapIndexed { index, ex -> ExerciseWithResult(ex, ExerciseWithResult.ExerciseResult.Count(8*index)) }.toSet()),
        Exam(id = 5, date = Date(), exercises = exercises.subList(2, 5).mapIndexed { index, ex -> ExerciseWithResult(ex, ExerciseWithResult.ExerciseResult.Count(16*index)) }.toSet()),
    )
}
