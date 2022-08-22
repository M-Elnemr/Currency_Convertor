package com.a1softech.core.data.di

import com.a1softech.core.data.repository.RepositoryImpl
import com.a1softech.core.data.repository.datasource.LocalDataSource
import com.a1softech.core.data.repository.datasource.LocalDataSourceImpl
import com.a1softech.core.data.repository.datasource.RemoteDataSource
import com.a1softech.core.data.repository.datasource.RemoteDataSourceImpl
import com.a1softech.core.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(repository: RepositoryImpl): Repository = repository

    @Provides
    @Singleton
    fun provideLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource =
        localDataSourceImpl

    @Provides
    @Singleton
    fun provideRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource =
        remoteDataSourceImpl

}