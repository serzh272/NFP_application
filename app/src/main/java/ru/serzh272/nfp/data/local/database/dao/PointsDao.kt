package ru.serzh272.nfp.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import ru.serzh272.nfp.data.local.database.entity.PointsEntity
import ru.serzh272.nfp.data.local.database.entity.WeightConstraintEntity

@Dao
interface PointsDao {

    @Query("SELECT points.points FROM points LEFT JOIN weight_constraint ON points.id = weight_constraint.points_id WHERE exercise_id = :exerciseId AND gender = :gender AND result = :result AND `constraint` = :weightConstraint")
    suspend fun getPoints(exerciseId: Int, gender: PointsEntity.Gender, result: Int, weightConstraint: WeightConstraintEntity.WeightConstraint? = null): Int
}
