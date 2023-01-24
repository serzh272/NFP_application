package ru.serzh272.nfp.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.serzh272.nfp.domain.model.Exercise
import ru.serzh272.nfp.domain.repository.INormsRepository
import javax.inject.Inject

class GetExercisesUseCase @Inject constructor(
    private val normsRepository: INormsRepository
) {
    operator fun invoke(): Flow<List<Exercise>> {
        return normsRepository.getExercises()
    }
}
