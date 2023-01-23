package ru.serzh272.nfp.presentation.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ru.serzh272.nfp.R

data class Exercise(
    val id: Long,
    val description: String,
    val exerciseType: ExerciseType,
    @DrawableRes val  iconRes: Int = R.drawable.ic_image_placeholder
){

    enum class ExerciseType(@StringRes val humanizeNameRes: Int, @DrawableRes val iconRes: Int){
        STRENGTH(R.string.strength, R.drawable.ic_strength),
        SPEED(R.string.speed, R.drawable.ic_speed),
        ENDURANCE(R.string.endurance, R.drawable.ic_endurance),
        AGILITY(R.string.agility, R.drawable.ic_agility),
        MILITARY_SKILLS(R.string.military_skills, R.drawable.ic_military),
    }
}
