package ru.serzh272.nfp.presentation.component

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.serzh272.nfp.domain.repository.IMainRepository
import javax.inject.Inject

interface IMainViewModel {

}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: IMainRepository,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel(), IMainViewModel {


}
