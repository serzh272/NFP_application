package ru.serzh272.nfp.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import ru.serzh272.nfp.data.local.database.entity.UserCategoryEntity

@Dao
interface UserCategoryDao {

    @Query("SELECT * FROM user_category WHERE id = :dbId")
    fun getUserCategoryByDbId(dbId: Long): UserCategoryEntity?
}
