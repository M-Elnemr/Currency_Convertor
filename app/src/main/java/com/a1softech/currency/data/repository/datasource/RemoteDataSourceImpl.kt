package com.a1softech.currency.data.repository.datasource

import com.a1softech.currency.data.apiservice.ApiInterface
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val apiInterface: ApiInterface) :
    RemoteDataSource {

}