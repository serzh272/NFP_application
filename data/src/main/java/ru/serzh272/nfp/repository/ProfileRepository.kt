package ru.serzh272.nfp.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull
import ru.serzh272.nfp.data.local.database.RoomDb
import ru.serzh272.nfp.profile.model.UserFullInfo
import ru.serzh272.nfp.profile.repository.IProfileRepository
import ru.serzh272.nfp.toUserFullInfo
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val db: RoomDb,
): IProfileRepository {
    override fun getProfile(): Flow<UserFullInfo> {
        return db.userDao.getCurrentUser().mapNotNull { it?.toUserFullInfo(db) }
    }
}
