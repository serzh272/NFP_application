package ru.serzh272.nfp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.serzh272.nfp.data.local.database.RoomDatabaseCallback
import ru.serzh272.nfp.data.local.database.RoomDb

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): RoomDb {
        return Room.databaseBuilder(context, RoomDb::class.java, RoomDb.DATABASE_NAME)
            .addCallback(RoomDatabaseCallback())
            .build()
    }
}
