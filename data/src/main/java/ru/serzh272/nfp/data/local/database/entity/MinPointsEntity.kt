package ru.serzh272.nfp.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import ru.serzh272.nfp.enums.Gender

@Entity(
    tableName = "min_points",
    indices = [
        Index("id", unique = true),
        Index("age_group_id", "user_category_id", "gender", unique = true),
    ],
    foreignKeys = [
        ForeignKey(
            entity = UserCategoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["user_category_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = AgeGroupEntity::class,
            parentColumns = ["id"],
            childColumns = ["age_group_id"],
            onDelete = ForeignKey.SET_NULL,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class MinPointsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "age_group_id", defaultValue = "NULL")
    val ageGroupId: Long? = null,
    @ColumnInfo(name = "user_category_id")
    val userCategoryId: Long,
    @ColumnInfo(defaultValue = "MALE")
    val gender: Gender = Gender.MALE,
    @ColumnInfo(name = "min_points_by_ex")
    val minPointsByEx: Int,
)
