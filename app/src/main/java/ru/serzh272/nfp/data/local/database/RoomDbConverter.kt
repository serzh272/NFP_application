package ru.serzh272.nfp.data.local.database

import androidx.room.TypeConverter
import java.util.*

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
