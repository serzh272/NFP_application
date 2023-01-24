package ru.serzh272.nfp.data.local.database

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

internal class RoomDatabaseCallback : RoomDatabase.Callback() {
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        //TODO temporary data setting
        db.execSQL("INSERT INTO exercise (id, exercise_name, exercise_type, created) VALUES (1, '1. Сгибание, разгибание рук в упоре лежа.', 'strength', 1674564655392)")
        db.execSQL("INSERT INTO exercise (id, exercise_name, exercise_type, created) VALUES (2, '2. Наклоны туловища вперед.', 'strength', 1674564655392)")
        db.execSQL("INSERT INTO exercise (id, exercise_name, exercise_type, created) VALUES (4, '4. Подтягивание на перекладине.', 'strength', 1674564655392)")
        db.execSQL("INSERT INTO exercise (id, exercise_name, exercise_type, created) VALUES (5, '5. Поднимание ног к перекладине.', 'strength', 1674564655392)")
        db.execSQL("INSERT INTO exercise (id, exercise_name, exercise_type, created) VALUES (6, '6. Подъем переворотом на перекладине.', 'strength', 1674564655392)")
        db.execSQL("INSERT INTO exercise (id, exercise_name, exercise_type, created) VALUES (7, '7. Подъем силой на перекладине.', 'strength', 1674564655392)")
        db.execSQL("INSERT INTO exercise (id, exercise_name, exercise_type, created) VALUES (8, '8. Жим штанги лежа. Вес штанги - 70 кг.', 'strength', 1674564655392)")
        db.execSQL("INSERT INTO exercise (id, exercise_name, exercise_type, created) VALUES (9, '9. Сгибание и разгибание рук в упоре на брусьях.', 'strength', 1674564655392)")
        db.execSQL("INSERT INTO exercise (id, exercise_name, exercise_type, created) VALUES (10, '10. Угол в упоре на брусьях.', 'strength', 1674564655392)")
        db.execSQL("INSERT INTO exercise (id, exercise_name, exercise_type, created) VALUES (11, '11. Рывок гири. Вес гири 24 кг.', 'strength', 1674564655392)")
        db.execSQL("INSERT INTO exercise (id, exercise_name, exercise_type, created) VALUES (12, '12. Толчок двух гирь. Вес гири 24 кг.', 'strength', 1674564655392)")
        db.execSQL("INSERT INTO exercise (id, exercise_name, exercise_type, created) VALUES (13, '13. Толчок двух гирь по длинному циклу. Вес гири 24 кг.', 'strength', 1674564655392)")
        db.execSQL("INSERT INTO exercise (id, exercise_name, exercise_type, created) VALUES (14, '14. Прыжок согнув ноги через коня (козла) в ширину.', 'agility', 1674564655392)")
        db.execSQL("INSERT INTO exercise (id, exercise_name, exercise_type, created) VALUES (15, '15. Прыжок ноги врозь через козла в длину.', 'agility', 1674564655392)")
        db.execSQL("INSERT INTO exercise (id, exercise_name, exercise_type, created) VALUES (16, '16. Прыжок ноги врозь через коня в длину.', 'agility', 1674564655392)")
        db.execSQL("INSERT INTO exercise (id, exercise_name, exercise_type, created) VALUES (17, '17. Кувырок вперед.', 'agility', 1674564655392)")
    }
}
