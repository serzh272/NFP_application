package ru.serzh272.nfp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import ru.serzh272.nfp.enums.WeightConstraint

@Entity(
    tableName = "weight_constraint",
    indices = [Index("id", unique = true), Index("points_id", unique = false)],
    foreignKeys = [
        ForeignKey(ru.serzh272.nfp.data.local.database.entity.PointsEntity::class, parentColumns = ["id"], childColumns = ["points_id"])
    ]
)
data class WeightConstraintEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "points_id")
    val pointsId: Long,
    val constraint: WeightConstraint
)
