package ru.serzh272.nfp.norms.repository

import kotlinx.coroutines.flow.Flow
import ru.serzh272.nfp.model.ExerciseDomain

interface INormsRepository {
    fun getExercises(): Flow<List<ExerciseDomain>>
}
