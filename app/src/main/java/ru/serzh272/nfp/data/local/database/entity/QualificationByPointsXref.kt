package ru.serzh272.nfp.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "qualification_by_points_xref",
    indices = [
        Index("category_id", "group_id", unique = true),
    ],
    primaryKeys = ["category_id", "group_id"],
    foreignKeys = [
        ForeignKey(CategoryEntity::class, parentColumns = ["id"], childColumns = ["category_id"]),
        ForeignKey(GroupEntity::class, parentColumns = ["id"], childColumns = ["group_id"]),
    ]
)
data class QualificationByPointsXref(
    @ColumnInfo(name = "category_id")
    val categoryId: Long,
    @ColumnInfo(name = "group_id")
    val groupId: Long,
    @ColumnInfo(name = "exercise_count")
    val exerciseCount: Int,
    val points: Int,
    @ColumnInfo(name = "mark_id")
    val qualification: Qualification,
){
    enum class Qualification{
        HIGH_LEVEL,
        FIRST_LEVEL,
        SECOND_LEVEL,
        THIRD_LEVEL,
    }
}
