package ru.serzh272.nfp.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import ru.serzh272.nfp.data.local.database.entity.enums.Gender
import ru.serzh272.nfp.data.local.database.entity.enums.WeightConstraint

@Dao
interface PointsDao {

    @Query("SELECT points.points FROM points LEFT JOIN weight_constraint ON points.id = weight_constraint.points_id WHERE exercise_id = :exerciseId AND gender = :gender AND result = :result AND `constraint` = :weightConstraint")
    suspend fun getPoints(exerciseId: Int, gender: Gender, result: Int, weightConstraint: WeightConstraint? = null): Int
}
