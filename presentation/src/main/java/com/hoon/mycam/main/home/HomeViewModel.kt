package com.hoon.mycam.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.filter
import com.hoon.data.BuildConfig
import com.hoon.data.lookup.model.CampingBasedInfoState
import com.hoon.data.utils.default
import com.hoon.domain.lookup.usecase.CampingInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (private val campingInfoUseCase: CampingInfoUseCase):ViewModel() {
    private val _campingBasedInfo: MutableStateFlow<CampingBasedInfoState> = MutableStateFlow(CampingBasedInfoState.Init)
    val campingBasedInfo: StateFlow<CampingBasedInfoState> get() = _campingBasedInfo.asStateFlow()

    fun campingBasedInfo() =
        viewModelScope.launch {
            campingInfoUseCase()
                .onStart {
                    _campingBasedInfo.value = CampingBasedInfoState.IsLoading(true)
                }.catch { exception ->
                    _campingBasedInfo.value = CampingBasedInfoState.IsLoading(false)
                    _campingBasedInfo.value = CampingBasedInfoState.Failure(exception.message.default())
                }.collect {
                    _campingBasedInfo.value = CampingBasedInfoState.IsLoading(false)
                    _campingBasedInfo.value = CampingBasedInfoState.Success(it)
                }
        }
}