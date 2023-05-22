package com.hoon.data.inquiry.repository.remote
import com.hoon.data.inquiry.dto.BasedDto
import com.hoon.data.inquiry.dto.ImageDto
import com.hoon.data.utils.WrappedResponse

interface InquiryRemoteDataSource {
    suspend fun getBasedList(pageNo: Int): WrappedResponse<BasedDto>
    suspend fun getImageList(pageNo: Int, contentId: Int): WrappedResponse<ImageDto>
}