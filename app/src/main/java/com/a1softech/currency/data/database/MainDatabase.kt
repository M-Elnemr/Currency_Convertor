package com.a1softech.currency.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.a1softech.currency.data.database.history.HistoryDao
import com.a1softech.currency.data.database.history.HistoryEntity

@Database(entities = [HistoryEntity::class], version = 1)
abstract class MainDatabase: RoomDatabase() {

    abstract fun historyDao(): HistoryDao
}