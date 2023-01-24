package ru.serzh272.nfp.data.local.database

import androidx.room.TypeConverter
import ru.serzh272.nfp.data.local.database.entity.ExerciseEntity
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
    fun fromExerciseType(type: ExerciseEntity.ExerciseType): String {
        return type.name.lowercase()
    }

    @TypeConverter
    fun toExerciseType(type: String): ExerciseEntity.ExerciseType {
        return ExerciseEntity.ExerciseType.fromString(type)
    }

    @TypeConverter
    fun fromExerciseUnit(type: ExerciseEntity.ExerciseUnit): String {
        return type.name.lowercase()
    }

    @TypeConverter
    fun toExerciseUnit(type: String): ExerciseEntity.ExerciseUnit {
        return ExerciseEntity.ExerciseUnit.valueOf(type.uppercase())
    }
}
