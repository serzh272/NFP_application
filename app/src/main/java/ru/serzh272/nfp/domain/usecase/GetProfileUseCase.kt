package ru.serzh272.nfp.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.serzh272.nfp.domain.model.UserFullInfo
import ru.serzh272.nfp.domain.repository.IProfileRepository
import javax.inject.Inject

class GetProfileUseCase @Inject constructor(
    private val profileRepository: IProfileRepository
) {
    operator fun invoke(): Flow<UserFullInfo> {
        return profileRepository.getProfile()
    }
}
