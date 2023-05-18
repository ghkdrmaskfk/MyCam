package com.hoon.data.lookup

import com.hoon.data.lookup.api.LookUpApi
import com.hoon.data.lookup.datasource.LookUpRemoteDataSource
import com.hoon.data.lookup.datasource.LookUpRemoteDataSourceImpl
import com.hoon.data.lookup.repository.LookUpRepositoryImpl
import com.hoon.data.module.NetworkModule
import com.hoon.domain.lookup.repository.LookUpRepository
import com.hoon.domain.lookup.usecase.CampingInfoUseCase
import com.hoon.domain.lookup.usecase.CampingInfoUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class LookUpModule {
    @Singleton
    @Provides
    fun provideLookUpApi(retrofit: Retrofit) : LookUpApi {
        return retrofit.create(LookUpApi::class.java)
    }

    @Singleton
    @Provides
    fun provideLookUpRemoteDataSource(api: LookUpApi) : LookUpRemoteDataSource {
        return LookUpRemoteDataSourceImpl(api)
    }

    @Singleton
    @Provides
    fun provideLookUpRepository(dataSource: LookUpRemoteDataSource) : LookUpRepository {
        return LookUpRepositoryImpl(dataSource)
    }

    @Singleton
    @Provides
    fun provideCampingInfoUseCase (repository: LookUpRepository) : CampingInfoUseCase {
        return CampingInfoUseCaseImpl(repository)
    }
}