package ru.serzh272.nfp.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "mark",
    indices = [Index("id", unique = true)]
)
data class MarkEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "mark_name")
    val markName: String,
    val points: Int
)
