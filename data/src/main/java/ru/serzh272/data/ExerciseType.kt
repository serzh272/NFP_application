package ru.serzh272.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

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
            }catch (_: IllegalArgumentException){
                UNDEFINED
            }
        }
    }
}
