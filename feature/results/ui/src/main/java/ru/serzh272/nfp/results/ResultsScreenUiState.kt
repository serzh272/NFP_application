package ru.serzh272.nfp.results

import ru.serzh272.nfp.model.Exam

data class ResultsScreenUiState(
    val exams: List<Exam> = emptyList(),
)
