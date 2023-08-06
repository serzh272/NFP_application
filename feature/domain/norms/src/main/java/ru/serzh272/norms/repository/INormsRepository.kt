package ru.serzh272.norms.repository

import kotlinx.coroutines.flow.Flow
import ru.serzh272.norms.model.Exercise

interface INormsRepository {
    fun getExercises(): Flow<List<Exercise>>
}
