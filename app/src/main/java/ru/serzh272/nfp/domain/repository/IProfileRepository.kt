package ru.serzh272.nfp.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.serzh272.nfp.domain.model.UserFullInfo

interface IProfileRepository {
    fun getProfile(): Flow<UserFullInfo>
}
