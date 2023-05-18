package com.hoon.data.lookup.datasource
import com.hoon.data.lookup.model.CampingBasedItemsEntity
import com.hoon.data.utils.WrappedResponse

interface LookUpRemoteDataSource {
    suspend fun getCampingBasedInfo(pageNo: Int): WrappedResponse<CampingBasedItemsEntity>
}