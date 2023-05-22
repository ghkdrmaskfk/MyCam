package com.hoon.data.inquiry

import com.hoon.data.inquiry.api.InquiryApi
import com.hoon.data.inquiry.repository.local.InquiryLocalDataSource
import com.hoon.data.inquiry.repository.local.InquiryLocalDataSourceImpl
import com.hoon.data.inquiry.repository.remote.InquiryRemoteDataSource
import com.hoon.data.inquiry.repository.remote.InquiryRemoteDataSourceImpl
import com.hoon.data.inquiry.repository.InquiryRepositoryImpl
import com.hoon.data.module.NetworkModule
import com.hoon.domain.inquiry.repository.InquiryRepository
import com.hoon.domain.inquiry.usecase.BasedInfoUseCase
import com.hoon.domain.inquiry.usecase.ImageInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class InquiryModule {
    @Singleton
    @Provides
    fun provideInquiryApi(retrofit: Retrofit) : InquiryApi {
        return retrofit.create(InquiryApi::class.java)
    }

    @Singleton
    @Provides
    fun provideInquiryRemoteDataSource(api: InquiryApi) : InquiryRemoteDataSource {
        return InquiryRemoteDataSourceImpl(api)
    }

    @Singleton
    @Provides
    fun provideInquiryLocalDataSource() : InquiryLocalDataSource {
        return InquiryLocalDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideInquiryRepository(remoteDataSource: InquiryRemoteDataSource, localDataSource: InquiryLocalDataSource) : InquiryRepository {
        return InquiryRepositoryImpl(remoteDataSource, localDataSource)
    }

    @Singleton
    @Provides
    fun provideBasedInfoUseCase (repository: InquiryRepository): BasedInfoUseCase {
        return BasedInfoUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideImageInfoUseCase (repository: InquiryRepository): ImageInfoUseCase {
        return ImageInfoUseCase(repository)
    }
}