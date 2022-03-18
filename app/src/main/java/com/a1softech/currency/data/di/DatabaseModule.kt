package com.a1softech.currency.data.di

import android.content.Context
import androidx.room.Room
import com.a1softech.currency.data.database.MainDatabase
import com.a1softech.currency.data.database.history.HistoryDao
import com.a1softech.currency.presentation.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): MainDatabase =
        Room.databaseBuilder(context, MainDatabase::class.java, Constants.DATABASE_NAME).build()

    @Provides
    @Singleton
    fun provideHistoryDao(mainDataBase: MainDatabase): HistoryDao = mainDataBase.historyDao()
}