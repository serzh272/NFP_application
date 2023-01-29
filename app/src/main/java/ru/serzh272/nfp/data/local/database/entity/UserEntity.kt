package ru.serzh272.nfp.data.local.database.entity

import androidx.room.*
import ru.serzh272.nfp.data.local.database.entity.enums.Gender
import java.util.*

@Entity(
    tableName = "user",
    indices = [
        Index("id", unique = true),
        Index("category_id","group_id", unique = false),
    ],
    foreignKeys = [
        ForeignKey(CategoryEntity::class, parentColumns = ["id"], childColumns = ["category_id"]),
        ForeignKey(GroupEntity::class, parentColumns = ["id"], childColumns = ["group_id"]),
    ]
)
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "category_id")
    val categoryId: Long,
    @ColumnInfo(name = "group_id")
    val groupId: Long,
    @ColumnInfo(name = "birth_date")
    val birthDate: Date,
    val gender: Gender = Gender.MALE,
    val weight: Float,
)
