package ru.serzh272.norms.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ru.serzh272.nfp.core.ui.R as CoreUiR

enum class ExerciseType(@StringRes val humanizeNameRes: Int, @DrawableRes val iconRes: Int) {
    STRENGTH(CoreUiR.string.strength, CoreUiR.drawable.ic_strength),
    SPEED(CoreUiR.string.speed, CoreUiR.drawable.ic_speed),
    ENDURANCE(CoreUiR.string.endurance, CoreUiR.drawable.ic_endurance),
    AGILITY(CoreUiR.string.agility, CoreUiR.drawable.ic_agility),
    MILITARY_SKILLS(CoreUiR.string.military_skills, CoreUiR.drawable.ic_military),
    UNDEFINED(CoreUiR.string.military_skills, CoreUiR.drawable.ic_military),;

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
