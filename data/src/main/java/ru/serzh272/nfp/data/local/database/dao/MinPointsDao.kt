package ru.serzh272.nfp.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import ru.serzh272.nfp.data.local.database.entity.MinPointsEntity

@Dao
interface MinPointsDao {

    @Query("SELECT * FROM min_points WHERE id = :dbId")
    fun getMinPointsByDbId(dbId: Long): MinPointsEntity?
}
