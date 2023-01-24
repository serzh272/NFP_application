package ru.serzh272.nfp.data.repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.serzh272.nfp.domain.model.DataHolder
import ru.serzh272.nfp.domain.model.Exercise
import ru.serzh272.nfp.domain.repository.INormsRepository
import javax.inject.Inject

class NormsRepository @Inject constructor(): INormsRepository {
    override fun getExercises(): Flow<List<Exercise>> = flow {
        emit(DataHolder.exercises.take(8))
        delay(4000)
        emit(DataHolder.exercises)
    }
}
