package ru.serzh272.nfp.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import ru.serzh272.nfp.repository.IMainRepository
import ru.serzh272.nfp.repository.MainRepository

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Binds
    fun bindMainRepository(repository: MainRepository): IMainRepository

}
