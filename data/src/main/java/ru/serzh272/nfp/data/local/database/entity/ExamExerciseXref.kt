package ru.serzh272.nfp.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "exam_exercise_xref",
    indices = [
        Index("exam_id", "exercise_id", unique = true),
    ],
    primaryKeys = ["exam_id", "exercise_id"],
    foreignKeys = [
        ForeignKey(ExamEntity::class, parentColumns = ["id"], childColumns = ["exam_id"]),
        ForeignKey(ExerciseEntity::class, parentColumns = ["id"], childColumns = ["exercise_id"]),
    ]
)
data class ExamExerciseXref(
    @ColumnInfo(name = "exam_id")
    val examId: Long,
    @ColumnInfo(name = "exercise_id")
    val exerciseId: Long,
    val result: Int,
    val points: Int? = null
)
