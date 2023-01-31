package ru.serzh272.nfp.data.mapper

import ru.serzh272.nfp.data.local.database.RoomDb
import ru.serzh272.nfp.data.local.database.entity.UserEntity
import ru.serzh272.nfp.domain.model.UserFullInfo

fun UserEntity.toUserFullInfo(db: RoomDb): UserFullInfo? {
    val group = db.groupDao.getGroupByDbId(this.groupId)
    val category = group?.categoryId?.let { db.categoryDao.getCategoryByDbId(it) }
    val minPoints = group?.minPointsId?.let { db.minPointsDao.getMinPointsByDbId(it) }
    val ageGroup = minPoints?.ageGroupId?.let { db.ageGroupDao.getAgeGroupByDbId(it) }
    val userCategory = minPoints?.userCategoryId?.let { db.userCategoryDao.getUserCategoryByDbId(it) }
    return userCategory?.let {
        UserFullInfo(
            id = id,
            category = category?.run { id to categoryName },
            ageGroup = ageGroup?.run{ id to ageGroupName },
            userCategory = it.run{ id to userCategoryName }
        )
    }
}
