package com.hoon.data.inquiry.model

import androidx.paging.PagingData
import com.hoon.domain.inquiry.model.BasedInfoVo

sealed class BasedInfoState {
    object Init : BasedInfoState()
    data class IsLoading(val isLoading: Boolean) : BasedInfoState()
    data class Success(val basedInfoList: PagingData<BasedInfoVo>): BasedInfoState()
    data class Failure(val message: String) : BasedInfoState()
}