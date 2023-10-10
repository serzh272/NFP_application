package ru.serzh272.nfp.profile.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import ru.serzh272.common.constants.NfpCoroutineDispatchers
import ru.serzh272.nfp.profile.model.UserFullInfo
import ru.serzh272.nfp.profile.repository.IProfileRepository
import javax.inject.Inject

class GetProfileUseCase @Inject constructor(
    private val profileRepository: IProfileRepository,
    private val dispatchers: NfpCoroutineDispatchers,
) {
    operator fun invoke(): Flow<UserFullInfo> {
        return profileRepository.getProfile().flowOn(dispatchers.io)
    }
}
