package com.hoon.data.inquiry.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hoon.data.inquiry.BasedPagingSource
import com.hoon.data.inquiry.ImagePagingSource
import com.hoon.data.inquiry.repository.local.InquiryLocalDataSource
import com.hoon.data.inquiry.repository.remote.InquiryRemoteDataSource
import com.hoon.domain.inquiry.model.BasedInfoVo
import com.hoon.domain.inquiry.model.ImageInfoVo
import com.hoon.domain.inquiry.repository.InquiryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InquiryRepositoryImpl @Inject constructor (
    private val dataSource: InquiryRemoteDataSource,
    private val localDataSource: InquiryLocalDataSource): InquiryRepository {
    override suspend fun getBasedList(): Flow<PagingData<BasedInfoVo>> {
        val pagingConfig = PagingConfig(pageSize = 10, enablePlaceholders = false)
        val pagingData = BasedPagingSource(dataSource)

        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                pagingData
            }
        ).flow
    }

    override suspend fun getImageList(contentId: Int): Flow<PagingData<ImageInfoVo>> {
        val pagingConfig = PagingConfig(pageSize = 10, enablePlaceholders = false)
        val pagingData = ImagePagingSource(dataSource, contentId)

        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                pagingData
            }
        ).flow
    }
}