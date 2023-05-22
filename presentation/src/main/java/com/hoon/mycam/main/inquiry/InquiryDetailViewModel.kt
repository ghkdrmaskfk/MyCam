package com.hoon.mycam.main.inquiry

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hoon.data.inquiry.model.ImageInfoState
import com.hoon.data.utils.default
import com.hoon.domain.inquiry.usecase.ImageInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InquiryDetailViewModel @Inject constructor (private val imageInfoUseCase: ImageInfoUseCase):
    ViewModel() {
    private val _imageInfo: MutableStateFlow<ImageInfoState> = MutableStateFlow(
        ImageInfoState.Init)
    val imageInfo: StateFlow<ImageInfoState> get() = _imageInfo.asStateFlow()

    fun getImageInfo(contentId: Int) =
        viewModelScope.launch {
            imageInfoUseCase(contentId)
                .onStart {
                    _imageInfo.value = ImageInfoState.IsLoading(true)
                }.catch { exception ->
                    _imageInfo.value = ImageInfoState.IsLoading(false)
                    _imageInfo.value = ImageInfoState.Failure(exception.message.default())
                }.collect {
                    _imageInfo.value = ImageInfoState.IsLoading(false)
                    _imageInfo.value = ImageInfoState.Success(it)
                }
        }
}