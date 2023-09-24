package ru.serzh272.nfp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.serzh272.data.repository.ProfileRepository
import ru.serzh272.norms.repository.IProfileRepository

@Module
@InstallIn(ViewModelComponent::class)
interface ProfileModule {

    @Binds
    fun bindProfileRepository(repository: ProfileRepository): IProfileRepository
}
