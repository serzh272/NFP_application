package ru.serzh272.nfp.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import ru.serzh272.nfp.data.local.database.entity.GroupEntity

@Dao
interface GroupDao {

    @Query("SELECT * FROM `group` WHERE id = :dbId")
    fun getGroupByDbId(dbId: Long): GroupEntity?
}
