package ru.serzh272.nfp.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import ru.serzh272.common.constants.NfpCoroutineDispatchers
import ru.serzh272.nfp.data.local.database.RoomDb
import ru.serzh272.nfp.data.mapper.toExercise
import ru.serzh272.nfp.model.ExerciseDomain
import ru.serzh272.nfp.norms.repository.INormsRepository
import javax.inject.Inject

class NormsRepository @Inject constructor(
    private val db: RoomDb,
    private val dispatchers: NfpCoroutineDispatchers,
): INormsRepository {
    override fun getExercises(): Flow<List<ExerciseDomain>> =
        db.exerciseDao.getAllExercises().map { exercises -> exercises.map { it.toExercise() } }.flowOn(dispatchers.io)
}
