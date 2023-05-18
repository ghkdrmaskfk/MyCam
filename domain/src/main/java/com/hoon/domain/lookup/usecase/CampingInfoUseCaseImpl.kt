package com.hoon.domain.lookup.usecase

import com.hoon.domain.lookup.repository.LookUpRepository

class CampingInfoUseCaseImpl(private val repository: LookUpRepository): CampingInfoUseCase {
    override suspend operator fun invoke() = repository.getCampingBasedInfo()
}