package com.hoon.data.lookup.datasource

import android.util.Log
import com.hoon.data.lookup.api.LookUpApi
import com.hoon.data.lookup.model.CampingBasedItemsEntity
import com.hoon.data.utils.WrappedResponse
import javax.inject.Inject

class LookUpRemoteDataSourceImpl @Inject constructor (private val api: LookUpApi): LookUpRemoteDataSource {
    override suspend fun getCampingBasedInfo(pageNo: Int): WrappedResponse<CampingBasedItemsEntity> = api.getCampingBasedInfo(pageNo)
}