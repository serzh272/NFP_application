package ru.serzh272.nfp.data.local.database.entity

import androidx.room.*

@Entity(
    tableName = "points",
    indices = [Index("id", unique = true)],
    foreignKeys = [
        ForeignKey(ExerciseEntity::class, parentColumns = ["id"], childColumns = ["exercise_id"])
    ]
)
data class PointsEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "exercise_id")
    val exerciseId: Long,
    val gender: Gender = Gender.MALE,
    val result: Int,
    val points: Int,
    ){
    enum class Gender{
        MALE,
        FEMALE,
    }
}
