package ru.serzh272.nfp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.serzh272.data.repository.MainRepository
import ru.serzh272.repository.IMainRepository

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Binds
    fun bindMainRepository(repository: MainRepository): IMainRepository

}
