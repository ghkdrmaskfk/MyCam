package com.hoon.data.lookup.api

import com.hoon.data.BuildConfig
import com.hoon.data.lookup.model.CampingBasedItemsEntity
import com.hoon.data.utils.WrappedResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface LookUpApi {
    @GET("B551011/GoCamping/basedList")
    suspend fun getCampingBasedInfo(
        @Query("pageNo") pageNo: Int = 1,
        @Query("numOfRows") numOfRows: Int = 10,
        @Query("serviceKey") serviceKey: String = BuildConfig.API_KEY,
        @Query("MobileOS") mobileOS: String = "AND",
        @Query("MobileApp") mobileApp: String = "MyCam",
        @Query("_type") type: String = "json"
    ): WrappedResponse<CampingBasedItemsEntity>
}