package ru.serzh272.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import ru.serzh272.data.local.database.entity.enums.Gender
import java.time.LocalDate

@Entity(
    tableName = "user",
    indices = [
        Index("id", unique = true),
        Index("group_id", unique = false),
    ],
    foreignKeys = [
        ForeignKey(GroupEntity::class, parentColumns = ["id"], childColumns = ["group_id"]),
    ]
)
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String = "",
    @ColumnInfo(name = "group_id")
    val groupId: Long,
    @ColumnInfo(name = "birth_date")
    val birthDate: LocalDate,
    val gender: Gender = Gender.MALE,
    val weight: Float,
)
