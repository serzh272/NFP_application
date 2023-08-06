package ru.serzh272.nfp.presentation.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ru.serzh272.nfp.R
import ru.serzh272.core.ui.R as CoreUiR

sealed class RootNavigation(val route: String, @DrawableRes val iconRes: Int, @StringRes val resourceId: Int){
    object Norms: RootNavigation("norms", CoreUiR.drawable.ic_norms, R.string.norms)
    object Results: RootNavigation("results", CoreUiR.drawable.ic_results, R.string.results)
    object Profile: RootNavigation("profile", R.drawable.ic_military, R.string.profile)
    object Help: RootNavigation("help", CoreUiR.drawable.ic_help, R.string.help)
}
