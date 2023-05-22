package com.hoon.domain.inquiry.usecase

import com.hoon.domain.inquiry.repository.InquiryRepository

class BasedInfoUseCase(private val repository: InquiryRepository) {
    suspend operator fun invoke() = repository.getBasedList()
}