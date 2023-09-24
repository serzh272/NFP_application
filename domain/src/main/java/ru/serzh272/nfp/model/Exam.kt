package ru.serzh272.nfp.model

import java.util.Date

data class Exam(
    val id: Long,
    val date: Date = Date(),
    val exercises: Set<ExerciseWithResult>
)
