package ru.serzh272.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "mark_by_points_xref",
    indices = [
        Index("id", unique = true),
    ],
    foreignKeys = [
        ForeignKey(GroupEntity::class, parentColumns = ["id"], childColumns = ["group_id"]),
        ForeignKey(MarkEntity::class, parentColumns = ["id"], childColumns = ["mark_id"]),
    ]
)
data class MarkByPointsXref(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "group_id")
    val groupId: Long,
    @ColumnInfo(name = "exercise_count")
    val exerciseCount: Int,
    val points: Int,
    @ColumnInfo(name = "mark_id")
    val markId: Int,
)
