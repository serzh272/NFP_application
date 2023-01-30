package ru.serzh272.nfp.domain.repository

import io.reactivex.Observable
import ru.serzh272.nfp.domain.model.Exercise

interface INormsRepository {
    fun getExercises(): Observable<List<Exercise>>
}
