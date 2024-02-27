package ru.serzh272.nfp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.serzh272.nfp.data.local.database.entity.WeightConstraintEntity
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
import ru.serzh272.nfp.data.local.database.entity.AgeGroupEntity
import ru.serzh272.nfp.data.local.database.entity.CategoryEntity
import ru.serzh272.nfp.data.local.database.entity.CurrentUserEntity
import ru.serzh272.nfp.data.local.database.entity.ExamEntity
import ru.serzh272.nfp.data.local.database.entity.ExamExerciseXref
import ru.serzh272.nfp.data.local.database.entity.ExerciseEntity
import ru.serzh272.nfp.data.local.database.entity.GroupEntity
import ru.serzh272.nfp.data.local.database.entity.MarkByPointsXref
import ru.serzh272.nfp.data.local.database.entity.MarkEntity
import ru.serzh272.nfp.data.local.database.entity.MinPointsEntity
import ru.serzh272.nfp.data.local.database.entity.PointsEntity
import ru.serzh272.nfp.data.local.database.entity.QualificationByPointsXref
import ru.serzh272.nfp.data.local.database.entity.UserCategoryEntity
import ru.serzh272.nfp.data.local.database.entity.UserEntity

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
