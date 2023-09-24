package ru.serzh272.norms.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.serzh272.data.local.database.RoomDb
import ru.serzh272.norms.mapper.toExercise
import ru.serzh272.norms.model.ExerciseDomain
import javax.inject.Inject

class NormsRepository @Inject constructor(
    private val db: RoomDb,
): INormsRepository {
    override fun getExercises(): Flow<List<ExerciseDomain>> =
        db.exerciseDao.getAllExercises().map { exercises -> exercises.map { it.toExercise() } }
}
