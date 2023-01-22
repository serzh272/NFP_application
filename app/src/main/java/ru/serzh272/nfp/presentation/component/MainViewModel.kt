package ru.serzh272.nfp.presentation.component

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.serzh272.nfp.domain.repository.IMainRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val mainRepository: IMainRepository,
    val savedStateHandle: SavedStateHandle,
) : ViewModel(), IMainViewModel {


}