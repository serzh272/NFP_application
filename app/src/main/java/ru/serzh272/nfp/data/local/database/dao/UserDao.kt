package ru.serzh272.nfp.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.serzh272.nfp.data.local.database.entity.UserEntity

@Dao
interface UserDao {


    @Query("SELECT user.* FROM user INNER JOIN current_user ON current_user.id = user.id")
    fun getCurrentUser(): Flow<UserEntity?>
}
