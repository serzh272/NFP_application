package ru.serzh272.norms.repository

import kotlinx.coroutines.flow.Flow
import ru.serzh272.norms.model.UserFullInfo

interface IProfileRepository {
    fun getProfile(): Flow<UserFullInfo>
}
