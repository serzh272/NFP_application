package ru.serzh272.nfp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.serzh272.nfp.data.local.database.dao.ExerciseDao
import ru.serzh272.nfp.data.local.database.entity.ExerciseEntity

@Database(
    entities = [
        ExerciseEntity::class,
    ],
    version = RoomDb.DATABASE_VERSION
)
@TypeConverters(RoomDbConverter::class)
abstract class RoomDb : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "ru.serzh272.nfp.db"
        const val DATABASE_VERSION = 1
    }

    abstract val exersiseDao: ExerciseDao
}