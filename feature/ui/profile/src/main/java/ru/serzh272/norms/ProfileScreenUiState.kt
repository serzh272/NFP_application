package ru.serzh272.norms

import ru.serzh272.common.constants.EMPTY_STRING

data class ProfileScreenUiState(
    val userInfo: ru.serzh272.norms.model.UserFullInfo = ru.serzh272.norms.model.UserFullInfo(
        id = 0,
        category = null,
        ageGroup = null,
        userCategory = -1L to EMPTY_STRING
    )
)
