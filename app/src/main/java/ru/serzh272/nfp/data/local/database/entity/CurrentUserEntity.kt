package ru.serzh272.nfp.data.local.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "current_user",
    indices = [
        Index("id", unique = true),
    ],
    foreignKeys = [
        ForeignKey(UserEntity::class, parentColumns = ["id"], childColumns = ["id"], onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE),
    ]
)
data class CurrentUserEntity(
    @PrimaryKey
    val id: Long,
)
