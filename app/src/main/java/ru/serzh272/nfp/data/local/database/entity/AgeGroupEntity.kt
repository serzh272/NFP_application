package ru.serzh272.nfp.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "age_group",
    indices = [Index("id", unique = true)]
)
data class AgeGroupEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "age_group_name")
    val ageGroupName: String,
    @ColumnInfo(name = "min_age")
    val minAge: Int? = null,
    @ColumnInfo(name = "max_age")
    val maxAge: Int? = null,

)
