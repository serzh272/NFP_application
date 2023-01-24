package ru.serzh272.nfp.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.serzh272.nfp.data.local.database.entity.ExerciseEntity

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM exercise")
    fun getAllExercises(): Flow<List<ExerciseEntity>>
}
