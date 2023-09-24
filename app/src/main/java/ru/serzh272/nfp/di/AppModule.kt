package ru.serzh272.nfp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.serzh272.data.repository.MainRepository
import ru.serzh272.data.repository.NormsRepository
import ru.serzh272.data.repository.ProfileRepository
import ru.serzh272.norms.repository.INormsRepository
import ru.serzh272.repository.IMainRepository
import ru.serzh272.repository.IProfileRepository

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Binds
    fun bindMainRepository(repository: MainRepository): IMainRepository

    @Binds
    fun bindNormsRepository(repository: NormsRepository): INormsRepository

    @Binds
    fun bindProfileRepository(repository: ProfileRepository): IProfileRepository
}
