package com.hoon.domain.lookup.usecase

import androidx.paging.PagingData
import com.hoon.domain.lookup.model.CampingBasedInfoVo
import kotlinx.coroutines.flow.Flow

interface CampingInfoUseCase {
    suspend operator fun invoke(): Flow<PagingData<CampingBasedInfoVo>>
}