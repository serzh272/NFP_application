package ru.serzh272.nfp.presentation.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ru.serzh272.nfp.R
import ru.serzh272.core.ui.R as CoreUiR

sealed class RootNavigation(val route: String, @DrawableRes val iconRes: Int, @StringRes val resourceId: Int){
    object Norms: RootNavigation("norms", CoreUiR.drawable.ic_norms, CoreUiR.string.norms)
    object Results: RootNavigation("results", CoreUiR.drawable.ic_results, CoreUiR.string.results)
    object Profile: RootNavigation("profile", R.drawable.ic_military, CoreUiR.string.profile)
    object Help: RootNavigation("help", CoreUiR.drawable.ic_help, CoreUiR.string.help)
}
