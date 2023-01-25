package ru.serzh272.nfp.domain.model

data class ExerciseWithResult(
    val exercise: Exercise,
    val result: ExerciseResult
){

    sealed class ExerciseResult{
        data class Count(val count: Int): ExerciseResult()
        data class Time(val time: Long): ExerciseResult()
        data class Distance(val distance: Int): ExerciseResult()
        data class Mark(val mark: Int): ExerciseResult()
    }
}
