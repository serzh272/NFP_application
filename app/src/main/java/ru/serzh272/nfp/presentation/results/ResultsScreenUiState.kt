package ru.serzh272.nfp.presentation.results

import ru.serzh272.nfp.domain.model.Exam

data class ResultsScreenUiState(
    val exams: List<Exam> = emptyList(),
)
