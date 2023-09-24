package ru.serzh272.nfp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.serzh272.nfp.profile.repository.IProfileRepository
import ru.serzh272.nfp.repository.ProfileRepository

@Module
@InstallIn(ViewModelComponent::class)
interface ProfileModule {

    @Binds
    fun bindProfileRepository(repository: ProfileRepository): IProfileRepository
}
