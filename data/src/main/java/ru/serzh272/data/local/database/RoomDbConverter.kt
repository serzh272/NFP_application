package ru.serzh272.data.local.database

import androidx.room.TypeConverter
import java.util.Date

internal class RoomDbConverter {

    @TypeConverter
    fun dateFromLong(lngDate: Long?): Date? {
        return lngDate?.let { Date(it) }
    }

    @TypeConverter
    fun longFromDate(date: Date?): Long? {
        return date?.time
    }
}
