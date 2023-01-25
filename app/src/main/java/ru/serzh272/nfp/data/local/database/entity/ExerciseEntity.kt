package ru.serzh272.nfp.data.local.database.entity

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import ru.serzh272.nfp.R
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
    @ColumnInfo(defaultValue = "count")
    val unit: ExerciseUnit = ExerciseUnit.COUNT,
    val created: Date = Date(),
    val updated: Date? = null
    ){

    enum class ExerciseType(@StringRes val humanizeNameRes: Int, @DrawableRes val iconRes: Int) {
        STRENGTH(R.string.strength, R.drawable.ic_strength),
        SPEED(R.string.speed, R.drawable.ic_speed),
        ENDURANCE(R.string.endurance, R.drawable.ic_endurance),
        AGILITY(R.string.agility, R.drawable.ic_agility),
        MILITARY_SKILLS(R.string.military_skills, R.drawable.ic_military),
        UNDEFINED(R.string.military_skills, R.drawable.ic_military),;

        companion object {
            val availableValues: List<ExerciseType> = values().take(values().size - 1)
            fun fromString(type: String): ExerciseType {
                return try {
                    valueOf(type.uppercase())
                }catch (ex: IllegalArgumentException){
                    UNDEFINED
                }
            }
        }
    }

    enum class ExerciseUnit{
        COUNT,
        TIME,
        DISTANCE,
        MARK,
    }
}
