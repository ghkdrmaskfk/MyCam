package com.hoon.data.lookup.model

import androidx.paging.PagingData
import com.hoon.domain.lookup.model.CampingBasedInfoVo

sealed class CampingBasedInfoState {
    object Init : CampingBasedInfoState()
    data class IsLoading(val isLoading: Boolean) : CampingBasedInfoState()
    data class Success(val campingBasedInfoList: PagingData<CampingBasedInfoVo>): CampingBasedInfoState()
    data class Failure(val message: String) : CampingBasedInfoState()
}