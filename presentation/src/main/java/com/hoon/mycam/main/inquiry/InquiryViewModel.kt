package com.hoon.mycam.main.inquiry

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hoon.data.inquiry.model.BasedInfoState
import com.hoon.data.utils.default
import com.hoon.domain.inquiry.usecase.BasedInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InquiryViewModel @Inject constructor (private val basedInfoUseCase: BasedInfoUseCase):ViewModel() {
    private val _basedInfo: MutableStateFlow<BasedInfoState> = MutableStateFlow(BasedInfoState.Init)
    val basedInfo: StateFlow<BasedInfoState> get() = _basedInfo.asStateFlow()

    fun basedInfo() =
        viewModelScope.launch {
            basedInfoUseCase()
                .onStart {
                    _basedInfo.value = BasedInfoState.IsLoading(true)
                }.catch { exception ->
                    _basedInfo.value = BasedInfoState.IsLoading(false)
                    _basedInfo.value = BasedInfoState.Failure(exception.message.default())
                }.collect {
                    _basedInfo.value = BasedInfoState.IsLoading(false)
                    _basedInfo.value = BasedInfoState.Success(it)
                }
        }
}