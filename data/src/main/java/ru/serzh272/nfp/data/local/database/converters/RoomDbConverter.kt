package ru.serzh272.nfp.data.local.database.converters

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

internal class RoomDbConverter {

    @TypeConverter
    fun dateTimeFromString(strDate: String?): LocalDateTime? {
        return strDate?.let { LocalDateTime.parse(strDate, DateTimeFormatter.ISO_LOCAL_DATE_TIME) }
    }

    @TypeConverter
    fun dateTimeToString(date: LocalDateTime?): String? {
        return date?.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    }

    @TypeConverter
    fun dateFromString(strDate: String?): LocalDate? {
        return strDate?.let { LocalDate.parse(strDate, DateTimeFormatter.ISO_LOCAL_DATE) }
    }

    @TypeConverter
    fun dateToString(date: LocalDate?): String? {
        return date?.format(DateTimeFormatter.ISO_LOCAL_DATE)
    }
}
