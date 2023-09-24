package ru.serzh272.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(
    tableName = "exam",
    indices = [
        Index("id", unique = true),
        Index("user_id", unique = false),
    ],
    foreignKeys = [
        ForeignKey(UserEntity::class, parentColumns = ["id"], childColumns = ["user_id"], onUpdate = ForeignKey.CASCADE, onDelete = ForeignKey.CASCADE)
    ]
)
data class ExamEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "user_id")
    val userId: Long,
    @ColumnInfo(name = "exam_date")
    val examDate: LocalDate,
    val description: String? = null
)
