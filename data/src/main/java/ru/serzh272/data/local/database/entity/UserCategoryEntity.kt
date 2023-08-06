package ru.serzh272.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "user_category",
    indices = [Index("id", unique = true)]
)
data class UserCategoryEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "user_category_name")
    val userCategoryName: String,
)
