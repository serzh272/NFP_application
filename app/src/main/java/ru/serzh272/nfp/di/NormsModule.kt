package ru.serzh272.nfp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.serzh272.nfp.norms.repository.INormsRepository
import ru.serzh272.nfp.repository.NormsRepository

@Module
@InstallIn(ViewModelComponent::class)
interface NormsModule {

    @Binds
    fun bindNormsRepository(repository: NormsRepository): INormsRepository
}
