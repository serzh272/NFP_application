package ru.serzh272.nfp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.serzh272.nfp.data.repository.MainRepository
import ru.serzh272.nfp.data.repository.NormsRepository
import ru.serzh272.nfp.domain.repository.IMainRepository
import ru.serzh272.nfp.domain.repository.INormsRepository

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Binds
    fun bindMainRepository(repository: MainRepository): IMainRepository

    @Binds
    fun bindNormsRepository(repository: NormsRepository): INormsRepository
}
