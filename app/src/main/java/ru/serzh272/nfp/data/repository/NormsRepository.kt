package ru.serzh272.nfp.data.repository

import io.reactivex.Observable
import ru.serzh272.nfp.data.local.database.RoomDb
import ru.serzh272.nfp.data.mapper.toExercise
import ru.serzh272.nfp.domain.model.Exercise
import ru.serzh272.nfp.domain.repository.INormsRepository
import javax.inject.Inject

class NormsRepository @Inject constructor(
    private val db:RoomDb,
): INormsRepository {
    override fun getExercises(): Observable<List<Exercise>> = db.exerciseDao.getAllExercises().map { exercises -> exercises.map { it.toExercise() } }
}
