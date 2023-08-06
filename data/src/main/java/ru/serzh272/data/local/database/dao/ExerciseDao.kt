package ru.serzh272.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import ru.serzh272.data.local.database.entity.ExerciseEntity

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM exercise")
    fun getAllExercises(): Flow<List<ExerciseEntity>>

    @Upsert
    fun addExercises(exercises: List<ExerciseEntity>)
}
