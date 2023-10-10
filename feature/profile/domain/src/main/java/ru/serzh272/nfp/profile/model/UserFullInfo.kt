package ru.serzh272.nfp.profile.model


data class UserFullInfo(
    val id: Long,
    val category: Pair<Long, String>? = null,
    val ageGroup: Pair<Long, String>? = null,
    val userCategory: Pair<Long, String>,
)
