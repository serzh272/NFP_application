package ru.serzh272.nfp.data.local.database.entity

import androidx.room.*
import ru.serzh272.nfp.data.local.database.entity.enums.WeightConstraint

@Entity(
    tableName = "weight_constraint",
    indices = [Index("id", unique = true), Index("points_id", unique = false)],
    foreignKeys = [
        ForeignKey(PointsEntity::class, parentColumns = ["id"], childColumns = ["points_id"])
    ]
)
data class WeightConstraintEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "points_id")
    val pointsId: Long,
    val constraint: WeightConstraint
)
