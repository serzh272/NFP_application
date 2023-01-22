package ru.serzh272.nfp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import ru.serzh272.nfp.data.repository.MainRepository
import ru.serzh272.nfp.domain.repository.IMainRepository

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Binds
    fun bindMainRepository(repository: MainRepository): IMainRepository
}