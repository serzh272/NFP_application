package ru.serzh272.nfp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.serzh272.nfp.data.local.database.dao.*
import ru.serzh272.nfp.data.local.database.entity.*

@Database(
    entities = [
        ExerciseEntity::class,
        ExamEntity::class,
        ExamExerciseXref::class,
        PointsEntity::class,
        WeightConstraintEntity::class,
        AgeGroupEntity::class,
        CategoryEntity::class,
        GroupEntity::class,
        MarkByPointsXref::class,
        MarkEntity::class,
        QualificationByPointsXref::class,
        UserEntity::class,
        CurrentUserEntity::class,
        MinPointsEntity::class,
        UserCategoryEntity::class
    ],
    version = RoomDb.DATABASE_VERSION
)
@TypeConverters(RoomDbConverter::class)
abstract class RoomDb : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "ru.serzh272.nfp.db"
        const val DATABASE_VERSION = 2
    }

    abstract val exerciseDao: ExerciseDao
    abstract val examDao: ExamDao
    abstract val pointsDao: PointsDao
    abstract val userDao: UserDao
    abstract val groupDao: GroupDao
    abstract val categoryDao: CategoryDao
    abstract val ageGroupDao: AgeGroupDao
    abstract val minPointsDao: MinPointsDao
    abstract val userCategoryDao: UserCategoryDao
}
