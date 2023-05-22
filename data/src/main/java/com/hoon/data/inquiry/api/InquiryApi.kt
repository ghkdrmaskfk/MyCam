package com.hoon.data.inquiry.api

import com.hoon.data.BuildConfig
import com.hoon.data.inquiry.dto.BasedDto
import com.hoon.data.inquiry.dto.ImageDto
import com.hoon.data.utils.WrappedResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface InquiryApi {
    @GET("B551011/GoCamping/basedList")
    suspend fun getBasedList(
        @Query("pageNo") pageNo: Int = 1,
        @Query("numOfRows") numOfRows: Int = 10,
        @Query("serviceKey") serviceKey: String = BuildConfig.API_KEY,
        @Query("MobileOS") mobileOS: String = "AND",
        @Query("MobileApp") mobileApp: String = "MyCam",
        @Query("_type") type: String = "json"
    ): WrappedResponse<BasedDto>

    @GET("B551011/GoCamping/imageList")
    suspend fun getImageList(
        @Query("pageNo") pageNo: Int = 1,
        @Query("contentId") contentId: Int,
        @Query("numOfRows") numOfRows: Int = 10,
        @Query("serviceKey") serviceKey: String = BuildConfig.API_KEY,
        @Query("MobileOS") mobileOS: String = "AND",
        @Query("MobileApp") mobileApp: String = "MyCam",
        @Query("_type") type: String = "json",

    ): WrappedResponse<ImageDto>
}