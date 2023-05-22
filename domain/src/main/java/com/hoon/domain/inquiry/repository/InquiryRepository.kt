package com.hoon.domain.inquiry.repository

import androidx.paging.PagingData
import com.hoon.domain.inquiry.model.BasedInfoVo
import com.hoon.domain.inquiry.model.ImageInfoVo
import kotlinx.coroutines.flow.Flow

interface InquiryRepository {
    suspend fun getBasedList() : Flow<PagingData<BasedInfoVo>>
    suspend fun getImageList(contentId: Int) : Flow<PagingData<ImageInfoVo>>
}