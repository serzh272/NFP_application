package ru.serzh272.nfp.presentation.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ru.serzh272.nfp.R

sealed class RootNavigation(val route: String, @DrawableRes val iconRes: Int, @StringRes val resourceId: Int){
    object Norms: RootNavigation("norms", R.drawable.ic_norms, R.string.norms)
    object Results: RootNavigation("results", R.drawable.ic_results, R.string.results)
    object Profile: RootNavigation("profile", R.drawable.ic_military, R.string.profile)
    object Help: RootNavigation("help", R.drawable.ic_help, R.string.help)
}