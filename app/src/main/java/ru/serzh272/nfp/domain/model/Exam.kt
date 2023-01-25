package ru.serzh272.nfp.domain.model

import java.util.*

data class Exam(
    val id: Long,
    val date: Date = Date(),
    val exercises: Set<ExerciseWithResult>
)
