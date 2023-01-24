package ru.serzh272.nfp.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.serzh272.nfp.data.local.database.RoomDb
import ru.serzh272.nfp.data.mapper.toExercise
import ru.serzh272.nfp.domain.model.Exercise
import ru.serzh272.nfp.domain.repository.INormsRepository
import javax.inject.Inject

class NormsRepository @Inject constructor(
    private val db:RoomDb,
): INormsRepository {
    override fun getExercises(): Flow<List<Exercise>> = db.exersiseDao.getAllExercises().map {exercises -> exercises.map { it.toExercise() } }
}
