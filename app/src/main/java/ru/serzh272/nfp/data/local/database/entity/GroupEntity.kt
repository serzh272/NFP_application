package ru.serzh272.nfp.data.local.database.entity

import androidx.room.*

@Entity(
    tableName = "group",
    indices = [
        Index("id", unique = true),
        Index("age_group_id", unique = false),
    ],
    foreignKeys = [
        ForeignKey(AgeGroupEntity::class, parentColumns = ["id"], childColumns = ["age_group_id"])
    ]
)
data class GroupEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "age_group_id")
    val ageGroupId: Long,
    @ColumnInfo(name = "group_name")
    val group_name: String,
    @ColumnInfo(name = "min_points_by_ex")
    val minPointsByEx: Int,

    )
