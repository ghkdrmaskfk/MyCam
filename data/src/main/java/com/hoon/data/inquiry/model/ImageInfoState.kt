package com.hoon.data.inquiry.model

import androidx.paging.PagingData
import com.hoon.domain.inquiry.model.ImageInfoVo

sealed class ImageInfoState {
    object Init : ImageInfoState()
    data class IsLoading(val isLoading: Boolean) : ImageInfoState()
    data class Success(val imageInfoList: PagingData<ImageInfoVo>): ImageInfoState()
    data class Failure(val message: String) : ImageInfoState()
}