package ru.serzh272.repository

import kotlinx.coroutines.flow.Flow
import ru.serzh272.data.UserFullInfo

interface IProfileRepository {
    fun getProfile(): Flow<UserFullInfo>
}
