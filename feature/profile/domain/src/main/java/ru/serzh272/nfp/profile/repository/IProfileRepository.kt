package ru.serzh272.nfp.profile.repository

import kotlinx.coroutines.flow.Flow
import ru.serzh272.nfp.profile.model.UserFullInfo

interface IProfileRepository {
    fun getProfile(): Flow<UserFullInfo>
}
