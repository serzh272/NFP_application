package ru.serzh272.nfp.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import ru.serzh272.nfp.data.local.database.entity.CategoryEntity

@Dao
interface CategoryDao {

    @Query("SELECT * FROM category WHERE id = :dbId")
    fun getCategoryByDbId(dbId: Long): CategoryEntity?
}
