package ru.serzh272.nfp.norms.usecase

import kotlinx.coroutines.flow.Flow
import ru.serzh272.nfp.model.ExerciseDomain
import ru.serzh272.nfp.norms.repository.INormsRepository
import javax.inject.Inject

class GetExercisesUseCase @Inject constructor(
    private val normsRepository: INormsRepository
) {
    operator fun invoke(): Flow<List<ExerciseDomain>> {
        return normsRepository.getExercises()
    }
}
