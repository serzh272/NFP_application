package ru.serzh272.nfp.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.serzh272.nfp.domain.model.Exercise

interface INormsRepository {
    fun getExercises(): Flow<List<Exercise>>
}
