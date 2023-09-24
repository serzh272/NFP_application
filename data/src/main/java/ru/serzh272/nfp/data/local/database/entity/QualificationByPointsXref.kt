package ru.serzh272.nfp.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import ru.serzh272.nfp.enums.Qualification

@Entity(
    tableName = "qualification_by_points_xref",
    indices = [
        Index("id", unique = true),
    ],
    foreignKeys = [
        ForeignKey(GroupEntity::class, parentColumns = ["id"], childColumns = ["group_id"]),
    ]
)
data class QualificationByPointsXref(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "group_id")
    val groupId: Long,
    @ColumnInfo(name = "exercise_count")
    val exerciseCount: Int,
    val points: Int,
    val qualification: Qualification,
)
