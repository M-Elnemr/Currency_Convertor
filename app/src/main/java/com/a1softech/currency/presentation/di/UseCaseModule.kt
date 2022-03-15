package com.a1softech.currency.presentation.di

import com.a1softech.currency.domain.usecase.FetchCurrencyListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideCurrencyListUSeCase(): FetchCurrencyListUseCase = FetchCurrencyListUseCase()

}