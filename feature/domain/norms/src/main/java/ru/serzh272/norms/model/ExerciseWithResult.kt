package ru.serzh272.norms.model

class ExerciseWithResult(
    val exercise: ExerciseDomain,
    val result: ExerciseResult
) {

    sealed class ExerciseResult {
        class Count(val count: Int) : ExerciseResult()
        class Time(val time: Long) : ExerciseResult()
        class Distance(val distance: Int) : ExerciseResult()
        class Mark(val mark: Int) : ExerciseResult()
    }
}
