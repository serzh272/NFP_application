package ru.serzh272.nfp.data.local.database

import androidx.room.TypeConverter
import ru.serzh272.nfp.data.local.database.entity.enums.ExerciseType
import ru.serzh272.nfp.data.local.database.entity.enums.ExerciseUnit
import java.util.*

internal class RoomDbConverter {

    @TypeConverter
    fun dateFromLong(lngDate: Long?): Date? {
        return lngDate?.let { Date(it) }
    }

    @TypeConverter
    fun longFromDate(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun fromExerciseType(type: ExerciseType): String {
        return type.name.lowercase()
    }

    @TypeConverter
    fun toExerciseType(type: String): ExerciseType {
        return ExerciseType.fromString(type)
    }

    @TypeConverter
    fun fromExerciseUnit(type: ExerciseUnit): String {
        return type.name.lowercase()
    }

    @TypeConverter
    fun toExerciseUnit(type: String): ExerciseUnit {
        return ExerciseUnit.valueOf(type.uppercase())
    }
}
