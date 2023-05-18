package com.hoon.data.lookup.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hoon.data.lookup.PagingSource
import com.hoon.data.lookup.datasource.LookUpRemoteDataSource
import com.hoon.data.lookup.mapper.mapperToCampingBasedInfoVo
import com.hoon.domain.lookup.model.CampingBasedInfoVo
import com.hoon.domain.lookup.repository.LookUpRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LookUpRepositoryImpl @Inject constructor (private val dataSource: LookUpRemoteDataSource): LookUpRepository {
    override suspend fun getCampingBasedInfo(): Flow<PagingData<CampingBasedInfoVo>> {
        val pagingConfig = PagingConfig(pageSize = 10, enablePlaceholders = false)
        val pagingData = PagingSource(dataSource)

        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                pagingData
            }
        ).flow
    }
}