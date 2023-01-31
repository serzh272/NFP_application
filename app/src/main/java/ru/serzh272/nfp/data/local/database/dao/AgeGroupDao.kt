package ru.serzh272.nfp.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import ru.serzh272.nfp.data.local.database.entity.AgeGroupEntity

@Dao
interface AgeGroupDao {

    @Query("SELECT * FROM age_group WHERE id = :dbId")
    fun getAgeGroupByDbId(dbId: Long): AgeGroupEntity?
}
