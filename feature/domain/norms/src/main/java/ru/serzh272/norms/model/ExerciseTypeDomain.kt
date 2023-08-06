package ru.serzh272.norms.model

enum class ExerciseTypeDomain {
    STRENGTH,
    SPEED,
    ENDURANCE,
    AGILITY,
    MILITARY_SKILLS,
    UNDEFINED;

    companion object {
        val availableValues: List<ExerciseTypeDomain> = values().take(values().size - 1)
        fun fromString(type: String): ExerciseTypeDomain {
            return try {
                valueOf(type.uppercase())
            }catch (ex: IllegalArgumentException){
                UNDEFINED
            }
        }
    }
}
