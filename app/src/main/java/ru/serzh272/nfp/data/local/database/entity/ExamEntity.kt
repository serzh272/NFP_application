package ru.serzh272.nfp.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "exam",
    indices = [Index("id", unique = true)]
)
data class ExamEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "exam_date")
    val examDate: Date,
    val description: String? = null
)
