package ru.serzh272.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "group",
    indices = [
        Index("id", unique = true),
        Index("category_id", "min_points_id", unique = true),
    ],
    foreignKeys = [
        ForeignKey(CategoryEntity::class, parentColumns = ["id"], childColumns = ["category_id"]),
        ForeignKey(MinPointsEntity::class, parentColumns = ["id"], childColumns = ["min_points_id"])
    ]
)
data class GroupEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "category_id", defaultValue = "NULL")
    val categoryId: Long? = null,
    @ColumnInfo(name = "min_points_id")
    val minPointsId: Long,
)
