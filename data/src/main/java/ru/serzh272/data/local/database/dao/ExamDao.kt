package ru.serzh272.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.serzh272.data.local.database.entity.ExamEntity

@Dao
interface ExamDao {

    @Query("SELECT * FROM exam")
    fun getAllExams(): Flow<List<ExamEntity>>
}
