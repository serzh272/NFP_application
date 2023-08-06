package ru.serzh272.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.serzh272.data.local.database.RoomDb
import ru.serzh272.data.local.database.migration.RoomDatabaseCallback
import ru.serzh272.data.local.database.migration.RoomMigrations

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): RoomDb {
        return Room.databaseBuilder(context, RoomDb::class.java, RoomDb.DATABASE_NAME)
            .addCallback(RoomDatabaseCallback())
            .addMigrations(migrations = RoomMigrations.migrations)
            .createFromAsset("nfp_prepopulated.db")
            .build()
    }
}
