package com.hoon.domain.inquiry.usecase

import com.hoon.domain.inquiry.repository.InquiryRepository

class ImageInfoUseCase(private val repository: InquiryRepository) {
    suspend operator fun invoke(contentId: Int) = repository.getImageList(contentId)
}