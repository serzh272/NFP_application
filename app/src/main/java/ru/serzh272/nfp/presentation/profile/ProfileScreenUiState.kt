package ru.serzh272.nfp.presentation.profile

import ru.serzh272.common.constants.EMPTY_STRING
import ru.serzh272.data.UserFullInfo

data class ProfileScreenUiState(
    val userInfo: UserFullInfo = UserFullInfo(id = 0, category = null, ageGroup = null, userCategory = -1L to EMPTY_STRING)
)
