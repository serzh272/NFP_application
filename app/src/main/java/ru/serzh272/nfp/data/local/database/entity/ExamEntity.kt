package ru.serzh272.nfp.data.local.database.entity

import androidx.room.*
import java.util.*

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
    val examDate: Date,
    val description: String? = null
)
