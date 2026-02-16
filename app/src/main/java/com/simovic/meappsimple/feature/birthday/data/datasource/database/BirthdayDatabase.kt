package com.simovic.meappsimple.feature.birthday.data.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.simovic.meappsimple.base.util.DateConverter
import com.simovic.meappsimple.feature.birthday.data.datasource.database.model.BirthDayRoomModel

@TypeConverters(DateConverter::class)
@Database(entities = [BirthDayRoomModel::class], version = 1, exportSchema = false)
internal abstract class BirthdayDatabase : RoomDatabase() {
    abstract fun birthDays(): BirthdayDao
}
