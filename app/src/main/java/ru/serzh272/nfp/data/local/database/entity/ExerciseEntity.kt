package ru.serzh272.nfp.data.local.database.entity

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import ru.serzh272.nfp.data.local.database.entity.enums.ExerciseType
import ru.serzh272.nfp.data.local.database.entity.enums.ExerciseUnit
import java.util.*

@Entity(
    tableName = "exercise",
    indices = [Index("id", unique = true)]
)
data class ExerciseEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "exercise_name")
    val exerciseName: String,
    @ColumnInfo(name = "exercise_type")
    val exerciseType: ExerciseType,
    val description: String? = null,
    @ColumnInfo(name = "only_military", defaultValue = "0")
    val onlyMilitary: Boolean = false,
    @DrawableRes val icon: Int? = null,
    @ColumnInfo(defaultValue = "COUNT")
    val unit: ExerciseUnit = ExerciseUnit.COUNT,
    val created: Date = Date(),
    val updated: Date? = null
)
