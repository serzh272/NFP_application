package ru.serzh272.norms.usecase

import kotlinx.coroutines.flow.Flow
import ru.serzh272.norms.model.ExerciseDomain
import ru.serzh272.norms.repository.INormsRepository
import javax.inject.Inject

class GetExercisesUseCase @Inject constructor(
    private val normsRepository: INormsRepository
) {
    operator fun invoke(): Flow<List<ExerciseDomain>> {
        return normsRepository.getExercises()
    }
}
