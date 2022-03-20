package com.a1softech.currency.data.database.history

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrencyConvertRecord(entity: HistoryEntity)

    @Query("SELECT * FROM history_table WHERE date = :date")
    fun fetchHistoricalRecordsByDate(date: String): Flow<List<HistoryEntity>>

    @Query("SELECT * FROM history_table WHERE currencyFrom = :baseCurrencyCode AND currencyTo = :otherCurrencyCode AND date IN(:dateList)")
    fun fetchHistoricalRecordsByCurrencyCodeAndDateList(
        baseCurrencyCode: String,
        otherCurrencyCode: String,
        dateList: List<String>
    ): Flow<List<HistoryEntity>>

    @Query("SELECT * FROM history_table")
    fun fetchAllHistoricalRecords(): Flow<List<HistoryEntity>>

    @Query("DELETE FROM history_table WHERE date NOT IN(:dateList)")
    suspend fun deleteOldHistoricalRecords(dateList: List<String>)
}