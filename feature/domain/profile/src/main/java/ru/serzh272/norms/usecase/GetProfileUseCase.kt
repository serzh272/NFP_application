package ru.serzh272.norms.usecase

import kotlinx.coroutines.flow.Flow
import ru.serzh272.norms.repository.IProfileRepository
import javax.inject.Inject

class GetProfileUseCase @Inject constructor(
    private val profileRepository: IProfileRepository
) {
    operator fun invoke(): Flow<ru.serzh272.norms.model.UserFullInfo> {
        return profileRepository.getProfile()
    }
}
