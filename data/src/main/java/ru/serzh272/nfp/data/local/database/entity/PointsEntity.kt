package ru.serzh272.nfp.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import ru.serzh272.nfp.enums.Gender

@Entity(
    tableName = "points",
    indices = [Index("id", unique = true)],
    foreignKeys = [
        ForeignKey(ExerciseEntity::class, parentColumns = ["id"], childColumns = ["exercise_id"])
    ]
)
data class PointsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "exercise_id")
    val exerciseId: Long,
    val gender: Gender = Gender.MALE,
    val result: Int,
    val points: Int,
)
