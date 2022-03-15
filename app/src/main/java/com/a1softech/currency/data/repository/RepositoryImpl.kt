package com.a1softech.currency.data.repository

import com.a1softech.currency.domain.Repository
import com.a1softech.currency.data.repository.datasource.LocalDataSource
import com.a1softech.currency.data.repository.datasource.RemoteDataSource
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : Repository {

}