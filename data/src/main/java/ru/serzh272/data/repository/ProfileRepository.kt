package ru.serzh272.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull
import ru.serzh272.data.UserFullInfo
import ru.serzh272.data.local.database.RoomDb
import ru.serzh272.data.toUserFullInfo
import ru.serzh272.repository.IProfileRepository
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val db: RoomDb,
): IProfileRepository {
    override fun getProfile(): Flow<UserFullInfo> {
        return db.userDao.getCurrentUser().mapNotNull { it?.toUserFullInfo(db) }
    }
}
