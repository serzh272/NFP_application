package ru.serzh272.nfp.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import io.reactivex.Observable
import ru.serzh272.nfp.data.local.database.entity.ExerciseEntity

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM exercise")
    fun getAllExercises(): Observable<List<ExerciseEntity>>

    @Upsert
    fun addExercises(exercises: List<ExerciseEntity>)
}
