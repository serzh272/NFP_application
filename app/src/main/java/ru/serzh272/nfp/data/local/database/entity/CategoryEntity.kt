package ru.serzh272.nfp.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "category",
    indices = [Index("id", unique = true)]
)
data class CategoryEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "category_name")
    val categoryName: String,
    val description: String
)
