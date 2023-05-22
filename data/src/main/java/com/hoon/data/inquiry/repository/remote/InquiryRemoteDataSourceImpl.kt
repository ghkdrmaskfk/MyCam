package com.hoon.data.inquiry.repository.remote

import com.hoon.data.inquiry.api.InquiryApi
import com.hoon.data.inquiry.dto.BasedDto
import com.hoon.data.inquiry.dto.ImageDto
import com.hoon.data.utils.WrappedResponse
import javax.inject.Inject

class InquiryRemoteDataSourceImpl @Inject constructor (private val api: InquiryApi):
    InquiryRemoteDataSource {
    override suspend fun getBasedList(pageNo: Int): WrappedResponse<BasedDto> = api.getBasedList(pageNo)
    override suspend fun getImageList(pageNo: Int, contentId: Int): WrappedResponse<ImageDto> = api.getImageList(pageNo, contentId)
}