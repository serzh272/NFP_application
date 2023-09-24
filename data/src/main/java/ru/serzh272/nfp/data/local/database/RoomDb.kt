package ru.serzh272.nfp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.serzh272.nfp.WeightConstraintEntity
import ru.serzh272.nfp.data.local.database.converters.RoomDbConverter
import ru.serzh272.nfp.data.local.database.dao.AgeGroupDao
import ru.serzh272.nfp.data.local.database.dao.CategoryDao
import ru.serzh272.nfp.data.local.database.dao.ExamDao
import ru.serzh272.nfp.data.local.database.dao.ExerciseDao
import ru.serzh272.nfp.data.local.database.dao.GroupDao
import ru.serzh272.nfp.data.local.database.dao.MinPointsDao
import ru.serzh272.nfp.data.local.database.dao.PointsDao
import ru.serzh272.nfp.data.local.database.dao.UserCategoryDao
import ru.serzh272.nfp.data.local.database.dao.UserDao

@Database(
    entities = [
        ru.serzh272.nfp.data.local.database.entity.ExerciseEntity::class,
        ru.serzh272.nfp.data.local.database.entity.ExamEntity::class,
        ru.serzh272.nfp.data.local.database.entity.ExamExerciseXref::class,
        ru.serzh272.nfp.data.local.database.entity.PointsEntity::class,
        WeightConstraintEntity::class,
        ru.serzh272.nfp.data.local.database.entity.AgeGroupEntity::class,
        ru.serzh272.nfp.data.local.database.entity.CategoryEntity::class,
        ru.serzh272.nfp.data.local.database.entity.GroupEntity::class,
        ru.serzh272.nfp.data.local.database.entity.MarkByPointsXref::class,
        ru.serzh272.nfp.data.local.database.entity.MarkEntity::class,
        ru.serzh272.nfp.data.local.database.entity.QualificationByPointsXref::class,
        ru.serzh272.nfp.data.local.database.entity.UserEntity::class,
        ru.serzh272.nfp.data.local.database.entity.CurrentUserEntity::class,
        ru.serzh272.nfp.data.local.database.entity.MinPointsEntity::class,
        ru.serzh272.nfp.data.local.database.entity.UserCategoryEntity::class
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
