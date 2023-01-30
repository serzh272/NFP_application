package ru.serzh272.nfp.domain.usecase

import io.reactivex.Observable
import ru.serzh272.nfp.domain.model.Exercise
import ru.serzh272.nfp.domain.repository.INormsRepository
import javax.inject.Inject

class GetExercisesUseCase @Inject constructor(
    private val normsRepository: INormsRepository
) {
    operator fun invoke(): Observable<List<Exercise>> {
        return normsRepository.getExercises()
    }
}
