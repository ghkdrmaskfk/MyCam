package com.hoon.domain.lookup.repository

import androidx.paging.PagingData
import com.hoon.domain.lookup.model.CampingBasedInfoVo
import kotlinx.coroutines.flow.Flow

interface LookUpRepository {
    suspend fun getCampingBasedInfo() : Flow<PagingData<CampingBasedInfoVo>>
}