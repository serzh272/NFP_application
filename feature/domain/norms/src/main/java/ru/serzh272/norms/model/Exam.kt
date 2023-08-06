package ru.serzh272.norms.model

import java.util.Date

data class Exam(
    val id: Long,
    val date: Date = Date(),
    val exercises: Set<ExerciseWithResult>
)
